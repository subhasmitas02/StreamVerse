/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: UserSubscriptionDto.java
 *
 */

package com.subhasmita.streamverse.subscription.dto;

import com.subhasmita.streamverse.subscription.entity.SubscriptionStatus;

import java.time.LocalDate;
import java.util.UUID;

public record UserSubscriptionDto(
        UUID id,
        UUID userId,
        UUID orderId,
        SubscriptionResponse subscription,
        LocalDate startDate,
        LocalDate endDate,
        SubscriptionStatus status
) {
}
