/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: UserService.java
 *
 */

package com.subhasmita.streamverse.content.security.services;

import java.util.UUID;

public interface UserService {
    UUID extractUserIdFromAuth();
    boolean hasAdminRoles();
}
