/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TokenPair.java
 *
 */

package com.subhasmita.streamverse.user.dto.common;

public record TokenPair(
        String accessToken,
        String accessTokenExpiry,
        String refreshToken,
        String refreshTokenExpiry
) {
}
