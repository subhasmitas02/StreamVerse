/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: EmailVerificationCodeMessage.java
 *
 */

package com.subhasmita.streamverse.customer.dto;

public record EmailVerificationCodeMessage(
        String email,
        String verificationCode,
        int codeExpirationTimeInMinutes
) {
}
