/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: ModerationMessage.java
 *
 */

package com.subhasmita.streamverse.comments.kafka.messages;

import com.subhasmita.streamverse.comments.entity.ModerationStatus;

import java.util.UUID;

public record ModerationMessage(
        UUID commentId,
        ModerationStatus moderationStatus
) {
}
