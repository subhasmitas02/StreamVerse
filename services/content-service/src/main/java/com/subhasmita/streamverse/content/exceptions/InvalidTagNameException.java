/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: InvalidTagNameException.java
 *
 */

package com.subhasmita.streamverse.content.exceptions;

public class InvalidTagNameException extends IllegalArgumentException {
    public InvalidTagNameException(String message) {
        super(message);
    }
}