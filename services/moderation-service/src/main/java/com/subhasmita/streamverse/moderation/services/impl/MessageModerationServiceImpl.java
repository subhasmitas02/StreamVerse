/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: MessageModerationServiceImpl.java
 *
 */

package com.subhasmita.streamverse.moderation.services.impl;

import com.subhasmita.streamverse.moderation.kafka.messages.CreatedNewMessage;
import com.subhasmita.streamverse.moderation.repositories.ModerationMessageRepository;
import com.subhasmita.streamverse.moderation.services.MessageModerationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageModerationServiceImpl implements MessageModerationService {

    private final ModerationMessageRepository repository;

    @Override
    public void startModeration(CreatedNewMessage message) {
    }

    @Override
    public void rejectMessage(String reason, UUID id) {

    }

    @Override
    public void approveMessage(UUID id) {

    }
}
