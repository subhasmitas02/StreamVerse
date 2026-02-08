/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: UserResponse.java
 *
 */

package com.subhasmita.streamverse.user.dto.responses;


import com.subhasmita.streamverse.user.entity.User;
import com.subhasmita.streamverse.user.enums.RecordStatus;
import com.subhasmita.streamverse.user.enums.Role;

import java.util.UUID;

public record UserResponse(
        UUID id,
        String email,
        RecordStatus recordStatus,
        Role role,
        Boolean isBanned
) {
    public static UserResponse toResponse(User user) {
        return new UserResponse(
                user.getId(),
                user.getEmail(),
                user.getRecordStatus(),
                Role.valueOf(user.getRole()),
                user.getIsBanned()
        );
    }
}
