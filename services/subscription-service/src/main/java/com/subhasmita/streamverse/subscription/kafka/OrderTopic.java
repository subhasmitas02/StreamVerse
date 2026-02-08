package com.subhasmita.streamverse.subscription.kafka;

import com.subhasmita.streamverse.subscription.dto.OrderCreationEventKafkaDto;
import com.subhasmita.streamverse.subscription.entity.UserSubscriptions;
import com.subhasmita.streamverse.subscription.service.UserSubscriptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import javax.naming.OperationNotSupportedException;

import static com.subhasmita.streamverse.subscription.kafka.KafkaTopics.ORDER_SUCCESSFULLY_COMPLETED_TOPIC;
import static com.subhasmita.streamverse.subscription.kafka.KafkaTopics.UNSUBSCRIBE_USER_TOPIC;


@Service
@Slf4j
@RequiredArgsConstructor
public class OrderTopic {

    private final UserSubscriptionService userSubscriptionService;

    @KafkaListener(topics = ORDER_SUCCESSFULLY_COMPLETED_TOPIC, groupId = "${spring.kafka.consumer.group-id}")
    private void consumeOrderTopic(OrderCreationEventKafkaDto dto) {
        log.info("Kafka consumer consumeOrderTopic: {}", dto);
        userSubscriptionService.subscribeUser(dto);
    }
}
