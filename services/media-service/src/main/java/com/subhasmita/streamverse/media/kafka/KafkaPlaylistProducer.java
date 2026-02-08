/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: KafkaPlaylistProducer.java
 *
 */

package com.subhasmita.streamverse.media.kafka;

import com.subhasmita.streamverse.media.kafka.messages.MasterPlaylistMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class KafkaPlaylistProducer {

    private final KafkaTemplate<String, MasterPlaylistMessage> kafkaTemplate;

    public void sendMasterPlaylistCreated(MasterPlaylistMessage masterPlaylistMessage) {
        kafkaTemplate.send("master-playlist-update-topic", masterPlaylistMessage);
    }
}
