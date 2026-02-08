/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CredentialsRequest.java
 *
 */

package com.subhasmita.streamverse.user.dto.requests;

public record CredentialsRequest(
        String login,
        String password
) {
}
