/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: ConvertingTaskDto.java
 *
 */

package com.subhasmita.streamverse.media.kafka.messages;

import com.subhasmita.streamverse.media.dto.ResolutionDto;
import com.subhasmita.streamverse.media.dto.VideoFileMetadataDto;

import java.util.UUID;

public record StartConvertingMessage(
        UUID metadataId,
        UUID videoId,
        ResolutionDto resolution
) {
}
