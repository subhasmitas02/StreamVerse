/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: MasterPlaylistCreatedMessage.java
 *
 */

package com.subhasmita.streamverse.media.kafka.messages;

import com.subhasmita.streamverse.media.enums.MediaType;

import java.util.UUID;

public record MasterPlaylistMessage(
        UUID contentId,
        MediaType mediaType,
        UUID masterPlaylistId,
        String masterPlaylistUrl
) { }
