/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CreateTopicRequest.java
 *
 */

package com.subhasmita.streamverse.moderation.dto.requests;

import java.util.UUID;

public record CreateTopicRequest (
        String title,
        String description,
        UUID categoryId
) {
}
