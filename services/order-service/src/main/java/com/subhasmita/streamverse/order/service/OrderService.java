/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: OrderService.java
 *
 */

package com.subhasmita.streamverse.order.service;

import com.subhasmita.streamverse.order.dto.OrderRequest;
import com.subhasmita.streamverse.order.dto.OrderResponse;
import com.subhasmita.streamverse.order.entity.OrderStatus;
import org.springframework.security.core.Authentication;

import java.util.List;
import java.util.UUID;

/**
 * OrderService provides methods for creating, retrieving, and updating orders.
 */
public interface OrderService {

    OrderResponse createOrder(OrderRequest orderRequest, Authentication authentication);

    OrderResponse getOrderById(UUID orderId);

    List<OrderResponse> getOrdersByUserId(UUID customerId);

    List<OrderResponse> getAllOrders();

    List<OrderResponse> getOrdersByAuthentication(Authentication authentication);

    void updateOrderStatus(UUID orderId, OrderStatus orderStatus);
}
