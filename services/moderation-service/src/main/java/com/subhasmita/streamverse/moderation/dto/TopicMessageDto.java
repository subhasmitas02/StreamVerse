/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TopicMessageDto.java
 *
 */

package com.subhasmita.streamverse.moderation.dto;

import java.util.UUID;

public record TopicMessageDto(
        UUID id,
        String content,
        UUID topicId
) {
}
