package com.subhasmita.streamverse.subscription.jobs;

import com.subhasmita.streamverse.subscription.entity.SubscriptionStatus;
import com.subhasmita.streamverse.subscription.entity.UserSubscriptions;
import com.subhasmita.streamverse.subscription.kafka.KafkaUserSubscriptionProducer;
import com.subhasmita.streamverse.subscription.service.impl.UserSubscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * FetchCanceledSubscriptionsJob is a class that implements the Job interface and is responsible for fetching canceled subscriptions
 * and sending them to a Kafka topic.
 */
@Component
@RequiredArgsConstructor
public class FetchCanceledSubscriptionsJob implements Job {

    private final UserSubscriptionServiceImpl service;
    private final KafkaUserSubscriptionProducer kafkaProducerService;

    /**
     * Executes the job to fetch cancelled subscriptions and send them to a Kafka topic.
     *
     * @param jobExecutionContext the execution context of the job
     * @throws JobExecutionException if the job execution fails
     */
    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDate now = LocalDate.now();
        List<UserSubscriptions> cancelledSubscriptions = service.getAllUserSubscriptionsByStatusAndEndDate(SubscriptionStatus.CANCELLED, now);

        for (UserSubscriptions subscription : cancelledSubscriptions) {
            kafkaProducerService.sendTopic(subscription);
        }
    }
}
