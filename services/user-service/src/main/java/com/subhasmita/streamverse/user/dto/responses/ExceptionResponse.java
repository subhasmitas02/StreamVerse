/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: ExceptionResponse.java
 *
 */

package com.subhasmita.streamverse.user.dto.responses;

import java.time.LocalDateTime;

public record ExceptionResponse(
        LocalDateTime timestamp,
        String message
) {
}
