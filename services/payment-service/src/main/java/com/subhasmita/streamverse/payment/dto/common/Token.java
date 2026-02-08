/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: Token.java
 *
 */

package com.subhasmita.streamverse.payment.dto.common;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

public record Token(
        UUID tokenId,
        UUID userId,
        String subject,
        String issuer,
        List<String> roles,
        Instant createdAt,
        Instant expiresAt
) {}
