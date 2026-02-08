/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: TaskProducer.java
 *
 */

package com.subhasmita.streamverse.media.kafka;

import com.subhasmita.streamverse.media.kafka.messages.StartConvertingMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;


import static com.subhasmita.streamverse.media.kafka.KafkaTopics.START_COMPRESSING_TOPIC;

@Service
@RequiredArgsConstructor
public class KafkaVideoProcessingProducer {

    private final KafkaTemplate<String, StartConvertingMessage> kafkaTemplate;

    public void sendTaskToQueue(StartConvertingMessage startConvertingMessage) {
        Message<StartConvertingMessage> message = MessageBuilder
                .withPayload(startConvertingMessage)
                .setHeader(KafkaHeaders.TOPIC, START_COMPRESSING_TOPIC)
                .build();
        kafkaTemplate.send(message);
    }
}
