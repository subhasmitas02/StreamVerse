/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: UserPrincipal.java
 *
 */

package com.subhasmita.streamverse.user.entity;

import org.springframework.security.core.userdetails.UserDetails;

import java.util.UUID;

public interface UserPrincipal extends UserDetails {
    UUID getId();
}
