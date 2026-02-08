/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: ModerationMessageRepository.java
 *
 */

package com.subhasmita.streamverse.moderation.repositories;

import com.subhasmita.streamverse.moderation.entity.ModerationMessage;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ModerationMessageRepository extends JpaRepository<ModerationMessage, UUID> {
}
