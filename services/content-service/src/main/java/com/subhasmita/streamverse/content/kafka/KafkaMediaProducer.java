/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: KafkaMediaProducer.java
 *
 */

package com.subhasmita.streamverse.content.kafka;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class KafkaMediaProducer {

    private KafkaTemplate<String, UUID> kafkaTemplate;

    public void sendDeleteMediaMessage(UUID movieId) {
        kafkaTemplate.send("delete-movie", movieId);
    }
}
