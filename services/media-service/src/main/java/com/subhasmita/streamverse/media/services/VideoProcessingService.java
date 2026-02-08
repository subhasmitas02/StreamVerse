/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: VideoProcessingService.java
 *
 */

package com.subhasmita.streamverse.media.services;

import com.subhasmita.streamverse.media.kafka.messages.StartConvertingMessage;

import java.util.UUID;

public interface VideoProcessingService {
    void processMediaFile(StartConvertingMessage task);
    void startVideoProcessing(UUID id);
}
