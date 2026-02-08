/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: KafkaUserProducer.java
 *
 */

package com.subhasmita.streamverse.user.kafka;

import com.subhasmita.streamverse.user.kafka.messages.CreateUserMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaUserProducer {

    private final KafkaTemplate<String, CreateUserMessage> kafkaTemplate;
    
    public void sendUserCreatedMessage(CreateUserMessage createUserMessage) {
        Message<CreateUserMessage> message = MessageBuilder
                .withPayload(createUserMessage)
                .setHeader(KafkaHeaders.TOPIC, "user-created-topic")
                .build();
        kafkaTemplate.send(message);
    }
}
