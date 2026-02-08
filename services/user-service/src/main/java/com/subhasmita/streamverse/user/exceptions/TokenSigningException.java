/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TokenSigningException.java
 *
 */

package com.subhasmita.streamverse.user.exceptions;

public class TokenSigningException extends RuntimeException {
    public TokenSigningException(String message, Throwable cause) {
        super(message, cause);
    }
}