package com.subhasmita.streamverse.order.kafka;

import com.subhasmita.streamverse.order.dto.CreateOrderMessage;
import com.subhasmita.streamverse.order.service.impl.OrderServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaConsumer {
    private final OrderServiceImpl orderService;

    @KafkaListener(topics = "payment-status", groupId = "payments")
    public void listenToPaymentStatusUpdate(String message) {
        System.out.println("Received message from topic1: " + message);
    }

    @KafkaListener(topics = "subscribe-user", groupId = "subscription")
    public void listenToSubscription(CreateOrderMessage message) {
//        orderService.createOrder(message);
        System.out.println("Received message from topic1: " + message);
    }
}
