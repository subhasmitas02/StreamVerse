/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: AuthenticationTokenFactory.java
 *
 */

package com.subhasmita.streamverse.user.factories;

import com.subhasmita.streamverse.user.dto.common.Token;
import org.springframework.security.core.Authentication;

import java.util.function.Function;

public interface AuthenticationTokenFactory extends Function<Authentication, Token> {
}
