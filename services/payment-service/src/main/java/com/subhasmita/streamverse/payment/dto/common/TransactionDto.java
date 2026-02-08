/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TransactionDto.java
 *
 */

package com.subhasmita.streamverse.payment.dto.common;

import com.subhasmita.streamverse.payment.entity.Transaction;
import com.subhasmita.streamverse.payment.enums.Currency;
import com.subhasmita.streamverse.payment.enums.PaymentStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record TransactionDto(
        UUID id,
        UUID orderId,
        UUID userId,
        Currency currency,
        BigDecimal amount,
        String failureMessage,
        PaymentStatus paymentStatus,
        LocalDateTime createdAt
) {
    public static TransactionDto toDto(Transaction transaction) {
        return new TransactionDto(
                transaction.getId(),
                transaction.getOrderId(),
                transaction.getCardHolder().getUserId(),
                transaction.getCurrency(),
                BigDecimal.valueOf(transaction.getAmount()).divide(BigDecimal.valueOf(transaction.getCurrency().getSmallestUnitMultiplier())),
                transaction.getFailureMessage(),
                transaction.getStatus(),
                transaction.getCreatedAt()
        );
    }
}
