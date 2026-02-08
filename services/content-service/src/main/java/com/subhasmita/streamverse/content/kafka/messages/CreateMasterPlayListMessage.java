/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CreateMasterPlayListMessage.java
 *
 */

package com.subhasmita.streamverse.content.kafka.messages;

import java.util.UUID;

public record CreateMasterPlayListMessage (
        UUID contentId,
        UUID masterPlaylistId,
        String url
) {
}
