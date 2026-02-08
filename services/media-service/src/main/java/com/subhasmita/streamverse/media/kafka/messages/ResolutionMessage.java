/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: ResolutionMessage.java
 *
 */

package com.subhasmita.streamverse.media.kafka.messages;

import com.subhasmita.streamverse.media.entity.Resolution;

import java.util.UUID;

public record ResolutionMessage (
        UUID id,
        Integer height,
        String name
) {
    public static ResolutionMessage toResolutionMessage(Resolution resolution) {
        return new ResolutionMessage(resolution.getId(), resolution.getHeight(), resolution.getName());
    }
}
