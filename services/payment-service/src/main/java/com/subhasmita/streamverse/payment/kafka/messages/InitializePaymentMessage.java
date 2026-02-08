/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: InitializePaymentMessage.java
 *
 */

package com.subhasmita.streamverse.payment.kafka.messages;

import com.subhasmita.streamverse.payment.enums.Currency;

import java.util.UUID;

public record InitializePaymentMessage (
        UUID orderId,
        UUID userId,
        Currency currency,
        Long amount
) {
}
