/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: KafkaProducer.java
 *
 */

package com.subhasmita.streamverse.media.kafka;

import com.subhasmita.streamverse.media.kafka.messages.ResolutionMessage;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import static com.subhasmita.streamverse.media.kafka.KafkaTopics.*;

@Component
public class KafkaResolutionProducer {

    private KafkaTemplate<String, ResolutionMessage> kafkaTemplate;

    public void sendCreatedResolutionTopic(ResolutionMessage resolutionResponse) {
        Message<ResolutionMessage> message = MessageBuilder
                .withPayload(resolutionResponse)
                .setHeader(KafkaHeaders.TOPIC, RESOLUTION_CREATED_TOPIC)
                .build();
        kafkaTemplate.send(message);
    }

    public void sendUpdateResolutionTopic(ResolutionMessage resolutionResponse) {
        Message<ResolutionMessage> message = MessageBuilder
                .withPayload(resolutionResponse)
                .setHeader(KafkaHeaders.TOPIC, RESOLUTION_UPDATED_TOPIC)
                .build();
        kafkaTemplate.send(message);
    }

    public void sendDeleteResolutionTopic(ResolutionMessage resolutionResponse) {
        Message<ResolutionMessage> message = MessageBuilder
                .withPayload(resolutionResponse)
                .setHeader(KafkaHeaders.TOPIC, RESOLUTION_DELETED_TOPIC)
                .build();
        kafkaTemplate.send(message);
    }
}
