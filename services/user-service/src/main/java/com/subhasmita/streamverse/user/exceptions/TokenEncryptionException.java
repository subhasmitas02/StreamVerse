/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TokenEncryptionException.java
 *
 */

package com.subhasmita.streamverse.user.exceptions;

public class TokenEncryptionException extends RuntimeException {
    public TokenEncryptionException(String message, Throwable cause) {
        super(message, cause);
    }
}