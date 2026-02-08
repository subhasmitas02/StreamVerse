/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: ResourceResponse.java
 *
 */

package com.subhasmita.streamverse.media.dto;

import org.springframework.core.io.Resource;
import org.springframework.http.HttpStatus;

public record ResourceDto(
        HttpStatus status,
        String contentType,
        String rangeLength,
        Long rangeStart,
        Long rangeEnd,
        Long fileLength,
        Resource resource
) {
}
