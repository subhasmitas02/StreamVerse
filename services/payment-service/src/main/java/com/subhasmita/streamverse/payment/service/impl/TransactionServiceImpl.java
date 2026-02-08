/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TransactionServiceImpl.java
 *
 */

package com.subhasmita.streamverse.payment.service.impl;

import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.subhasmita.streamverse.payment.dto.common.TransactionDto;
import com.subhasmita.streamverse.payment.dto.responses.PaginationResponse;
import com.subhasmita.streamverse.payment.entity.CardHolder;
import com.subhasmita.streamverse.payment.entity.JWTUserPrincipal;
import com.subhasmita.streamverse.payment.entity.Transaction;
import com.subhasmita.streamverse.payment.enums.PaymentStatus;
import com.subhasmita.streamverse.payment.kafka.PaymentKafkaProducer;
import com.subhasmita.streamverse.payment.kafka.messages.InitializePaymentMessage;
import com.subhasmita.streamverse.payment.repository.TransactionRepository;
import com.subhasmita.streamverse.payment.service.CardHolderService;
import com.subhasmita.streamverse.payment.service.TransactionService;
import com.subhasmita.streamverse.payment.specifications.TransactionSpecification;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository repository;
    private final CardHolderService cardHolderService;
    private final PaymentKafkaProducer paymentKafkaProducer;

    @Override
    public void initializeTransaction(InitializePaymentMessage message) {
        CardHolder cardHolder = cardHolderService.findCardHolderEntity(message.userId());

        Transaction transaction = Transaction.builder()
                .amount(message.amount())
                .currency(message.currency())
                .orderId(message.orderId())
                .status(PaymentStatus.PENDING)
                .cardHolder(cardHolder)
                .build();

        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(message.amount() * message.currency().getSmallestUnitMultiplier())
                        .setCurrency(message.currency().name().toLowerCase())
                        .setConfirm(true).setAutomaticPaymentMethods(PaymentIntentCreateParams.AutomaticPaymentMethods.builder()
                                .setEnabled(true).setAllowRedirects(PaymentIntentCreateParams.AutomaticPaymentMethods.AllowRedirects.NEVER).build())
                        .setCustomer(cardHolder.getStripeCustomerId())
                        .build();
        try {
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            transaction.setStripePaymentIntentId(paymentIntent.getId());
            transaction.setStatus(PaymentStatus.SUCCESS);
//            paymentKafkaProducer.sendInitializePaymentMessage(new PaymentStatusMessage(
//                    message.userId(), message.orderId(), PaymentStatus.SUCCESS, "Payment successful"
//            ));
        } catch (StripeException e) {
            transaction.setStatus(PaymentStatus.FAILED);
            transaction.setFailureMessage(e.getMessage());
//            paymentKafkaProducer.sendInitializePaymentMessage(new PaymentStatusMessage(
//                    message.userId(), message.orderId(), PaymentStatus.FAILED, e.getMessage()
//            ));
            throw new RuntimeException(e);
        } finally {
            repository.save(transaction);
        }
    }

    @Override
    public TransactionDto findTransaction(UUID transactionId) {

        return null;
    }

    @Override
    public Transaction findTransactionEntity(UUID transactionId) {
        return this.repository.findById(transactionId).orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    @Override
    public List<TransactionDto> getTransactions(Integer page, Integer size, String sort, PaymentStatus status, UUID userId) {
        Sort.Direction sortDirection = Sort.Direction.fromString(sort);
        Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, "amount"));

        if (SecurityContextHolder.getContext().getAuthentication().getPrincipal() instanceof JWTUserPrincipal jwtUserPrincipal) {
            if (jwtUserPrincipal.getAuthorities().stream()
                    .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
                userId = (userId != null) ? userId : jwtUserPrincipal.getUserId();
            } else {
                userId = jwtUserPrincipal.getUserId();
            }
            Specification<Transaction> specification = TransactionSpecification.buildSpec(status, userId);
            Page<Transaction> transactionPage = repository.findAll(specification, pageable);

            PaginationResponse<List<TransactionDto>> response = new PaginationResponse<>(
                    transactionPage.getTotalPages(),
                    transactionPage.getNumber(),
                    transactionPage.getNumberOfElements(),
                    transactionPage.getContent().stream().map(TransactionDto::toDto).toList()
            );
        }
        throw new AccessDeniedException("Access denied");
    }
}
