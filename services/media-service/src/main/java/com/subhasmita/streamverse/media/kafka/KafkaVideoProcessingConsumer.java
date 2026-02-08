/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: TaskConsumer.java
 *
 */

package com.subhasmita.streamverse.media.kafka;

import com.subhasmita.streamverse.media.kafka.messages.StartConvertingMessage;
import com.subhasmita.streamverse.media.services.VideoProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import static com.subhasmita.streamverse.media.kafka.KafkaTopics.START_COMPRESSING_TOPIC;


@Component
@RequiredArgsConstructor
public class KafkaVideoProcessingConsumer {

    private final VideoProcessingService videoProcessingService;

    @KafkaListener(topics = START_COMPRESSING_TOPIC, groupId = "${spring.kafka.consumer.group-id}")
    private void consumeCompressTask(StartConvertingMessage startConvertingMessage) {
        videoProcessingService.processMediaFile(startConvertingMessage);
    }
}
