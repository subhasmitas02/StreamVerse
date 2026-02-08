/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TokenDeserializer.java
 *
 */

package com.subhasmita.streamverse.content.security.serialization;




import com.subhasmita.streamverse.content.security.dto.Token;

import java.util.function.Function;

public interface TokenDeserializer extends Function<String, Token> {
}
