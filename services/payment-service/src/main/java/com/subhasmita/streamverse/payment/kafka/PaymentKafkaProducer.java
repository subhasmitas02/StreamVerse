/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: PaymentKafkaProducer.java
 *
 */

package com.subhasmita.streamverse.payment.kafka;


import com.subhasmita.streamverse.payment.kafka.messages.PaymentStatusMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentKafkaProducer {

    private final KafkaTemplate<String, PaymentStatusMessage> kafkaTemplate;

    public void sendInitializePaymentMessage(PaymentStatusMessage paymentStatusMessage) {
        Message<PaymentStatusMessage> message = MessageBuilder.withPayload(paymentStatusMessage).setHeader(""
                , KafkaTopics.START_PROCESS_PAYMENT).build();
        kafkaTemplate.send(message);
    }
}
