/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: MetadataDto.java
 *
 */

package com.subhasmita.streamverse.media.dto;

import java.util.UUID;

public record UploadMetadataDto(
        UUID id,
        int totalChunks
) {
}
