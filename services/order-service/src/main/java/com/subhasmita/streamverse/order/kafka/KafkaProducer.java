package com.subhasmita.streamverse.order.kafka;


import com.subhasmita.streamverse.order.dto.CreateOrderMessage;
import com.subhasmita.streamverse.order.dto.OrderResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class KafkaProducer {
    private final KafkaTemplate<String, CreateOrderMessage> kafkaTemplate;

    public void produceOrderMessage(OrderResponse order) {
    }
}
