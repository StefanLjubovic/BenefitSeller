package com.backend.payment.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
public class TransactionEntity extends BaseEntity{

    @Column(name="balance", unique=false, nullable=false)
    private Long value;

    @Column(name="description", unique=false, nullable=false)
    private String description;

    @ManyToOne
    @JoinColumn(name = "payment_card_id", nullable = false)
    private PaymentCardEntity paymentCard;

    @ManyToOne
    @JoinColumn(name = "benefit_id", nullable = false)
    private BenefitEntity benefit;

    @Enumerated(EnumType.STRING)
    @Column(name = "transaction_status", nullable = false)
    private TransactionStatus transactionStatus;
}
