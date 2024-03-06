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

    @ManyToOne
    @JoinColumn(name = "payment_card_id", nullable = false)
    private PaymentCardEntity paymentCard;

    @ManyToOne
    @JoinColumn(name = "benefit_id", nullable = false)
    private BenefitEntity benefit;
}
