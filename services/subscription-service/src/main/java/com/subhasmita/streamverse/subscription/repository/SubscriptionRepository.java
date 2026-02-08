package com.subhasmita.streamverse.subscription.repository;

import com.subhasmita.streamverse.subscription.dto.SubscriptionResponse;
import com.subhasmita.streamverse.subscription.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {
    SubscriptionResponse findBy();
}
