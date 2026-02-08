package com.subhasmita.streamverse.subscription.repository;

import com.subhasmita.streamverse.subscription.entity.SubscriptionStatus;
import com.subhasmita.streamverse.subscription.entity.UserSubscriptions;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserSubscriptionRepository extends JpaRepository<UserSubscriptions, UUID> {
    List<UserSubscriptions> findAllByStatusAndEndDate(SubscriptionStatus status, LocalDate endDate);

    Optional<UserSubscriptions> findByOrderId(UUID uuid);

    Optional<UserSubscriptions> findFirstByUserId(UUID id);

    Optional<UserSubscriptions> findByUserIdAndStatus(UUID id, SubscriptionStatus status);
}
