/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CreateUserMessage.java
 *
 */

package com.subhasmita.streamverse.user.kafka.messages;

import java.util.UUID;

public record CreateUserMessage(
        UUID id,
        String email,
        String username
) {
}
