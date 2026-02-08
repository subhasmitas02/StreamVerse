/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: RefundServiceImpl.java
 *
 */

package com.subhasmita.streamverse.payment.service.impl;

import com.stripe.exception.StripeException;
import com.stripe.model.Refund;
import com.stripe.param.RefundCreateParams;
import com.subhasmita.streamverse.payment.entity.Transaction;
import com.subhasmita.streamverse.payment.enums.RefundStatus;
import com.subhasmita.streamverse.payment.repository.RefundRepository;
import com.subhasmita.streamverse.payment.service.RefundService;
import com.subhasmita.streamverse.payment.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RefundServiceImpl implements RefundService {

    private final RefundRepository repository;
    private final TransactionService transactionService;

    @Override
    public void processRefund(UUID transactionId) {
        Transaction transaction = this.transactionService.findTransactionEntity(transactionId);

        com.subhasmita.streamverse.payment.entity.Refund refund =
                com.subhasmita.streamverse.payment.entity.Refund.builder()
                        .status(RefundStatus.SUCCESS)
                        .currency(transaction.getCurrency())
                        .transaction(transaction)
                        .build();

        RefundCreateParams params =
                RefundCreateParams.builder().setPaymentIntent(transaction.getStripePaymentIntentId()).build();

        try {
            Refund stripeRefund = Refund.create(params);
            refund.setStripeRefundId(stripeRefund.getId());
            refund.setAmount(stripeRefund.getAmount());
            refund.setStatus(RefundStatus.SUCCESS);
        } catch (StripeException e) {
            refund.setStatus(RefundStatus.FAILED);
            throw new RuntimeException(e);
        } finally {
            this.repository.save(refund);
        }
    }
}
