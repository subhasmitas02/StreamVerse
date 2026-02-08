package com.subhasmita.streamverse.subscription.kafka;

import com.subhasmita.streamverse.subscription.entity.UserSubscriptions;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import static com.subhasmita.streamverse.subscription.kafka.KafkaTopics.UNSUBSCRIBE_USER_TOPIC;

/**
 * KafkaUserSubscriptionProducer is a service class that is responsible for sending user subscriptions to a Kafka topic.
 */
@Service
public class KafkaUserSubscriptionProducer {

    private KafkaTemplate<String, UserSubscriptions> kafkaTemplate;

    public void sendTopic(UserSubscriptions userSubscriptions) {
        kafkaTemplate.send(UNSUBSCRIBE_USER_TOPIC, userSubscriptions);
    }
}
