/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: UserSubscriptionMapper.java
 *
 */

package com.subhasmita.streamverse.subscription.mapper;

import com.subhasmita.streamverse.subscription.dto.UserSubscriptionDto;
import com.subhasmita.streamverse.subscription.entity.UserSubscriptions;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * A component responsible for mapping UserSubscriptions entity to UserSubscriptionDto.
 */
@Component
@RequiredArgsConstructor
public class UserSubscriptionMapper {

    private final SubscriptionMapper subscriptionMapper;

    /**
     * Converts a UserSubscriptions entity to a UserSubscriptionDto.
     *
     * @param entity the UserSubscriptions entity to be converted.
     * @return a UserSubscriptionDto containing the converted data.
     */
    public UserSubscriptionDto toUserSubscriptionDto(UserSubscriptions entity) {
        return new UserSubscriptionDto(
                entity.getId(),
                entity.getUserId(),
                entity.getOrderId(),
                subscriptionMapper.toResponse(entity.getSubscription()),
                entity.getStartDate(),
                entity.getEndDate(),
                entity.getStatus()
        );
    }
}
