/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: UserService.java
 *
 */

package com.subhasmita.streamverse.media.security.services;

import java.util.UUID;

public interface UserService {
    UUID extractUserIdFromAuth();
    boolean hasAdminRoles();
}
