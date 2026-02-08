/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: TokenDeserializer.java
 *
 */

package com.subhasmita.streamverse.media.security.serialization;


import com.subhasmita.streamverse.media.security.dto.Token;

import java.util.function.Function;

public interface TokenDeserializer extends Function<String, Token> {
}
