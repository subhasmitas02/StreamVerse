/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TokenFactory.java
 *
 */

package com.subhasmita.streamverse.user.factories;

import com.subhasmita.streamverse.user.dto.common.Token;

import java.util.function.Function;

public interface TokenFactory extends Function<Token, Token> {
}
