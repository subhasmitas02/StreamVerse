/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: KafkaPaymentConsumer.java
 *
 */

package com.subhasmita.streamverse.payment.kafka;

import com.subhasmita.streamverse.payment.kafka.messages.InitializePaymentMessage;
import com.subhasmita.streamverse.payment.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaPaymentConsumer {

    private final TransactionService transactionService;

    @KafkaListener(topics = "start-payment-processing" , groupId = "spring.kafka.consumer.group-id")
    public void consume(InitializePaymentMessage message) {
        System.out.println("Consumed message: " + message);
        transactionService.initializeTransaction(message);
    }
}
