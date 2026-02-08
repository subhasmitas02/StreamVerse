/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: ImageDto.java
 *
 */

package com.subhasmita.streamverse.media.dto;

import org.springframework.core.io.ByteArrayResource;

public record ImageDto(
        ByteArrayResource byteArrayResource,
        String contentType
) {
}
