package com.subhasmita.streamverse.subscription.dto;

import java.util.UUID;

public record OrderCreationEventKafkaDto(
        UUID orderId,
        UUID userId,
        UUID subscriptionId
) {
}
