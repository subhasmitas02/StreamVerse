/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: ChangePasswordRequest.java
 *
 */

package com.subhasmita.streamverse.user.dto.requests;

import com.subhasmita.streamverse.user.validation.ValidPassword;
import jakarta.validation.constraints.NotBlank;
import org.springframework.validation.annotation.Validated;

@Validated
public record ChangePasswordRequest(

        @NotBlank(message = "Old password must not be blank")
        String oldPassword,

        @NotBlank(message = "New password must not be blank")
        @ValidPassword
        String newPassword
) {
}
