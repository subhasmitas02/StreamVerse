/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: CompressingException.java
 *
 */

package com.subhasmita.streamverse.media.exceptions;

public class CompressingException extends VideoStorageException {
    public CompressingException(String message, Throwable cause) {
        super(message, cause);
    }

    public CompressingException(String message) {
        super(message);
    }
}