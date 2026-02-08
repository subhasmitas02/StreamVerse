package com.subhasmita.streamverse.payment.entity;

import com.subhasmita.streamverse.payment.enums.Currency;
import com.subhasmita.streamverse.payment.enums.RefundStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "refunds")
public class Refund {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "amount")
    private Long amount;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;

    @Column(name = "stripe_refund_id")
    private String stripeRefundId;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private RefundStatus status;

    @Column(name = "created_at")
    @CreatedDate
    private LocalDateTime createdAt;

    @OneToOne
    @JoinColumn(name = "transaction_id", referencedColumnName = "id")
    private Transaction transaction;
}
