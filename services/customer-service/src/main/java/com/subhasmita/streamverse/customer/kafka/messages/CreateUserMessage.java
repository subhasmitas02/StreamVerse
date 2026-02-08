/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CreateCustomerMessage.java
 *
 */

package com.subhasmita.streamverse.customer.kafka.messages;

import java.util.UUID;

public record CreateUserMessage(
        UUID id,
        String email,
        String username
) {
}
