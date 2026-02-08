/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CreadtedNewMessage.java
 *
 */

package com.subhasmita.streamverse.comments.kafka.messages;

import java.util.UUID;

public record CreatedNewMessage(
        String content,
        UUID authorId,
        String authorUsername,
        UUID messageId
){

}
