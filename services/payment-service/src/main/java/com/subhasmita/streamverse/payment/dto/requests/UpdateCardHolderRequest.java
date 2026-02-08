/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: UpdateCardHolderRequest.java
 *
 */

package com.subhasmita.streamverse.payment.dto.requests;

public record UpdateCardHolderRequest(
        String cardHolderName,
        String phoneNumber,
        String email
) {
}
