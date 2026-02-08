/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: MessageModerationService.java
 *
 */

package com.subhasmita.streamverse.moderation.services;

import com.subhasmita.streamverse.moderation.kafka.messages.CreatedNewMessage;

import java.util.UUID;

public interface MessageModerationService {
    void startModeration(CreatedNewMessage message);
    void rejectMessage(String reason, UUID id);
    void approveMessage(UUID id);
}
