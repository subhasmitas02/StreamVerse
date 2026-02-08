/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: RegistrationRequest.java
 *
 */

package com.subhasmita.streamverse.user.dto.requests;

import com.subhasmita.streamverse.user.enums.Role;
import com.subhasmita.streamverse.user.validation.ValidPassword;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/**
 * Record class to represent the RegistrationRequest.
 */
public record RegistrationRequest(
        @NotBlank(message = "Username is mandatory") String username,
        @Email(message = "Email should be valid") String email,
        @NotBlank(message = "Password is mandatory") @ValidPassword String password,
        @NotBlank Role role
) {
}
