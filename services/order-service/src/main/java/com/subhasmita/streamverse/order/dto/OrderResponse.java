package com.subhasmita.streamverse.order.dto;


import com.subhasmita.streamverse.order.entity.OrderStatus;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record OrderResponse(
        UUID id,
        UUID customerId,
        BigDecimal amount,
        UUID subscriptionId,
        LocalDateTime orderDate,
        OrderStatus orderStatus
) {
}
