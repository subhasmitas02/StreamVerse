/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: EmailNotificationProducer.java
 *
 */

package com.subhasmita.streamverse.customer.kafka;


import com.subhasmita.streamverse.customer.dto.EmailVerificationCodeMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class EmailNotificationProducer {

    private KafkaTemplate<String, EmailVerificationCodeMessage> kafkaTemplate;

    public void sendEmailNotification(EmailVerificationCodeMessage message) {
        kafkaTemplate.send("email-verification", message);
    }
}
