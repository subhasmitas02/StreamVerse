/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: PaymentStatusMessage.java
 *
 */

package com.subhasmita.streamverse.payment.kafka.messages;

import com.subhasmita.streamverse.payment.enums.PaymentStatus;

import java.util.UUID;

public record PaymentStatusMessage(
        UUID userId,
        UUID orderId,
        PaymentStatus paymentStatus,
        String message
) {
}
