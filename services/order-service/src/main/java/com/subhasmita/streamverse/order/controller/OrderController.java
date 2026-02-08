package com.subhasmita.streamverse.order.controller;

import com.subhasmita.streamverse.order.dto.OrderRequest;
import com.subhasmita.streamverse.order.dto.OrderResponse;
import com.subhasmita.streamverse.order.entity.Order;
import com.subhasmita.streamverse.order.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderServiceImpl orderService;

    @PostMapping
    public ResponseEntity<OrderResponse> createOrder(@RequestBody OrderRequest orderRequest, Authentication authentication) {
        return ResponseEntity.ok(orderService.createOrder(orderRequest, authentication));
    }

    @PutMapping
    public ResponseEntity<UUID> updatePlan(@RequestBody OrderRequest orderRequest) {
        return null;
    }

    @GetMapping
    public ResponseEntity<OrderResponse> getOrder(@RequestParam UUID id) {
        return null;
    }

    @PutMapping
    @PreAuthorize("hasAnyAuthority('ROLE_SERVICE')")
    public ResponseEntity<Void> updateOrderStatus(@RequestBody Order order) {
        return null;
    }
}
