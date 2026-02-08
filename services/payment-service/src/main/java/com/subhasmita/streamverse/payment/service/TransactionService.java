/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TransactionService.java
 *
 */

package com.subhasmita.streamverse.payment.service;

import com.subhasmita.streamverse.payment.dto.common.TransactionDto;
import com.subhasmita.streamverse.payment.entity.Transaction;
import com.subhasmita.streamverse.payment.enums.PaymentStatus;
import com.subhasmita.streamverse.payment.kafka.messages.InitializePaymentMessage;

import java.util.List;
import java.util.UUID;

public interface TransactionService {
    void initializeTransaction(InitializePaymentMessage message);
    TransactionDto findTransaction(UUID transactionId);
    Transaction findTransactionEntity(UUID transactionId);
    List<TransactionDto> getTransactions(Integer page, Integer size, String sort, PaymentStatus status, UUID userId);
}
