/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: StreamVerse
 * File: MediaDeleteMessage.java
 *
 */

package com.subhasmita.streamverse.media.kafka.messages;

import java.util.UUID;

public record MediaDeleteMessage(
        UUID contentId
) {
}
