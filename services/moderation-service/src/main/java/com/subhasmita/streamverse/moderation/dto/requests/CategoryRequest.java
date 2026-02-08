/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CreateCategoryRequest.java
 *
 */

package com.subhasmita.streamverse.moderation.dto.requests;

public record CategoryRequest(
        String name,
        String description
) {
}