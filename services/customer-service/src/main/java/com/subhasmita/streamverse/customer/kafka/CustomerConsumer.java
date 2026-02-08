/*
 * Copyright (c) 2026 Subhasmita Sahu. All Rights Reserved.
 *
 * Project: STREAMING SERVICE APP
 * File: CustomerConcumer.java
 *
 */

package com.subhasmita.streamverse.customer.kafka;

import com.subhasmita.streamverse.customer.kafka.messages.CreateUserMessage;
import com.subhasmita.streamverse.customer.services.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CustomerConsumer {

    private final CustomerService customerService;

    @KafkaListener(topics = "user-created-topic", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(CreateUserMessage message) {
        System.out.println("Consumed message: " + message);
        customerService.createCustomer(message);
    }
}
