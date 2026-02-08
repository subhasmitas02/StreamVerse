package com.subhasmita.streamverse.order.repository;

import com.subhasmita.streamverse.order.entity.Order;
import com.subhasmita.streamverse.order.entity.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends JpaRepository<Order, UUID> {
    List<Order> findAllByUserIdAndOrderStatus(UUID uuid, OrderStatus orderStatus);
}
