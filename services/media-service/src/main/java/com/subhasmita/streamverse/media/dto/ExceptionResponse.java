/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: ExceptionResponse.java
 *
 */

package com.subhasmita.streamverse.media.dto;

import java.time.LocalDateTime;

public record ExceptionResponse(
        LocalDateTime timestamp,
        String message
) {
}
