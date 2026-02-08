/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CommentsResponse.java
 *
 */

package com.subhasmita.streamverse.comments.dto.response;

import java.util.List;
import java.util.UUID;

public record CommentsResponse(
        UUID id,
        String content,
        List<CommentsResponse> replies,
        UUID userId,
        String username,
        String profilePicture
) {
}
