/*
 * Copyright (c) 2026 Subhasmita Sahu.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *   The above copyright notice and this permission notice shall be included in
 *    all copies or substantial portions of the Software.
 *
 *    THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *    IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *    FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *     AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *     LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *     OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *      THE SOFTWARE.
 */

package com.subhasmita.streamverse.subscription.service.impl;

import com.subhasmita.jwtsecurity.service.JwtUserDetails;
import com.subhasmita.streamverse.subscription.clients.OrderClient;
import com.subhasmita.streamverse.subscription.dto.CreateOrderRequest;
import com.subhasmita.streamverse.subscription.dto.OrderCreationEventKafkaDto;
import com.subhasmita.streamverse.subscription.dto.OrderResponse;
import com.subhasmita.streamverse.subscription.dto.UserSubscriptionDto;
import com.subhasmita.streamverse.subscription.entity.Subscription;
import com.subhasmita.streamverse.subscription.entity.SubscriptionStatus;
import com.subhasmita.streamverse.subscription.entity.UserSubscriptions;
import com.subhasmita.streamverse.subscription.exceptions.NotFoundException;
import com.subhasmita.streamverse.subscription.mapper.UserSubscriptionMapper;
import com.subhasmita.streamverse.subscription.repository.UserSubscriptionRepository;
import com.subhasmita.streamverse.subscription.service.SubscriptionService;
import com.subhasmita.streamverse.subscription.service.UserSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.UUID;

/**
 * UserSubscriptionService is a class that provides methods for managing user subscriptions.
 */
@Service
@RequiredArgsConstructor
public class UserSubscriptionServiceImpl implements UserSubscriptionService {

    private final UserSubscriptionRepository repository;
    private final SubscriptionService subscriptionService;
    private final OrderClient orderClient;
    private final UserSubscriptionMapper mapper;


    public void subscribeUser(OrderCreationEventKafkaDto orderCreationEventKafkaDto) {
        Subscription subscription = subscriptionService.getSubscription(orderCreationEventKafkaDto.subscriptionId());
        Optional<UserSubscriptions> userSubscriptionsOptional = repository.findByOrderId(orderCreationEventKafkaDto.orderId());

        if (userSubscriptionsOptional.isPresent()) {
            UserSubscriptions userSubscriptions = userSubscriptionsOptional.get();

            if (!userSubscriptions.getSubscription().equals(subscription)) {
                userSubscriptions.setSubscription(subscription);
            }

            userSubscriptions.setStatus(SubscriptionStatus.ACTIVE);
            repository.save(userSubscriptions);
        } else {
            UserSubscriptions userSubscription = createUserSubscription(subscription, orderCreationEventKafkaDto.userId(), orderCreationEventKafkaDto.orderId());
            repository.save(userSubscription);
        }
    }

    public List<UserSubscriptions> getAllUserSubscriptionsByStatusAndEndDate(SubscriptionStatus status, LocalDate endDate) {
        return repository.findAllByStatusAndEndDate(status, endDate);
    }

    @Override
    public UserSubscriptionDto getActiveSubscription(JwtUserDetails jwtUserDetails, UUID uuid) {
        if (uuid != null) {
            return repository.findByUserIdAndStatus(uuid, SubscriptionStatus.ACTIVE)
                    .map(mapper::toUserSubscriptionDto)
                    .orElseThrow(() -> new NotFoundException("User didn't have subscription"));
        } else {
            return repository.findByUserIdAndStatus(jwtUserDetails.getId(), SubscriptionStatus.ACTIVE)
                    .map(mapper::toUserSubscriptionDto)
                    .orElseThrow(() -> new NotFoundException("User didn't have subscription"));
        }
    }

    public void cancelSubscription(UserSubscriptions subscription) throws OperationNotSupportedException {
        if (!subscription.getStatus().equals(SubscriptionStatus.CANCELLED)) {
            subscription.setStatus(SubscriptionStatus.CANCELLED);
            repository.save(subscription);
            // TODO send email to user that subscription is cancelled
        } else {
            throw new OperationNotSupportedException("Not allowed to repeat cancellation of subscription.");
        }
    }

    public void cancelSubscription(UUID subscriptionId) {
        UserSubscriptions userSubscriptions = repository.findById(subscriptionId).orElseThrow(() -> new NotFoundException("Subscription not found"));
        userSubscriptions.setStatus(SubscriptionStatus.CANCELLED);
        repository.save(userSubscriptions);
    }

    @Override
    public void cancelSubscription(JwtUserDetails jwtUserDetails) {
        UserSubscriptions userSubscriptions = repository.findByUserIdAndStatus(jwtUserDetails.getId(), SubscriptionStatus.ACTIVE).orElseThrow(() -> new NotFoundException("Subscription not found"));
        userSubscriptions.setStatus(SubscriptionStatus.CANCELLED);
        repository.save(userSubscriptions);
    }

    public void extendSubscription(UserSubscriptions userSubscription) throws IOException, OperationNotSupportedException {
        Subscription subscription = userSubscription.getSubscription();
        CreateOrderRequest createOrderRequest = new CreateOrderRequest(
                userSubscription.getUserId(),
                subscription.getIsTemporary() ? subscription.getNextSubscription().getId() : subscription.getId(),
                subscription.getIsTemporary() ? subscription.getNextSubscription().getPrice() : subscription.getPrice()
        );

        ResponseEntity<OrderResponse> response;
        try {
            response = orderClient.createOrder(createOrderRequest);
        } catch (Exception e) {
            throw new IOException("Unable to extend subscription due to: " + e.getMessage());
        }

        if (response.getStatusCode().is2xxSuccessful()) {
            UserSubscriptions newUserSubscription = createUserSubscription(subscription, userSubscription.getUserId(), Objects.requireNonNull(response.getBody()).id());
            repository.save(newUserSubscription);
            this.unsubscribeUser(userSubscription);
        } else {
            throw new IOException("Unable to extend subscription due to: " + response.getStatusCode());
        }
    }

    public void unsubscribeUser(UserSubscriptions subscription) throws OperationNotSupportedException {
        if (!subscription.getStatus().equals(SubscriptionStatus.EXPIRED)) {
            subscription.setStatus(SubscriptionStatus.EXPIRED);
            repository.save(subscription);
            // Send topic to users to change role
            // send topic to notify user
        } else {
            throw new OperationNotSupportedException("User is already unsubscribed.");
        }
    }

    private UserSubscriptions createUserSubscription(Subscription subscription, UUID userId, UUID orderId) {
        return UserSubscriptions.builder()
                .subscription(subscription)
                .orderId(orderId)
                .userId(userId)
                .status(SubscriptionStatus.ACTIVE)
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(subscription.getDurationInDays()))
                .build();
    }
}