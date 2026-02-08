package com.subhasmita.streamverse.subscription.jobs;

import com.subhasmita.streamverse.subscription.entity.SubscriptionStatus;
import com.subhasmita.streamverse.subscription.entity.UserSubscriptions;
import com.subhasmita.streamverse.subscription.service.impl.UserSubscriptionServiceImpl;
import lombok.RequiredArgsConstructor;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.stereotype.Component;

import javax.naming.OperationNotSupportedException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

@Component
@RequiredArgsConstructor
public class FetchActiveSubscriptionsJob implements Job {

    private final UserSubscriptionServiceImpl service;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        LocalDate now = LocalDate.now();
        List<UserSubscriptions> cancelledSubscriptions = service.getAllUserSubscriptionsByStatusAndEndDate(SubscriptionStatus.ACTIVE, now);

        for (UserSubscriptions subscription : cancelledSubscriptions) {
            try {
                service.extendSubscription(subscription);
            } catch (IOException | OperationNotSupportedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
