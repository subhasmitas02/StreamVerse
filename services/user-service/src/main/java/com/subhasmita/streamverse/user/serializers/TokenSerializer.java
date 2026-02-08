/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: TokenSerializer.java
 *
 */

package com.subhasmita.streamverse.user.serializers;

import com.subhasmita.streamverse.user.dto.common.Token;

import java.util.function.Function;

public interface TokenSerializer  extends Function<Token, String> {
}
