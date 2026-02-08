package com.subhasmita.streamverse.order.dto;

import java.math.BigDecimal;
import java.util.UUID;

public record OrderRequest(
        UUID userId,
        UUID subscriptionId,
        BigDecimal price
) {
}
