package com.backend.payment.model;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_entity")
@Getter
@Setter
public class UserEntity extends BaseEntity{

    @Column(name="first_name", nullable=false)
    private String firstName;

    @Column(name="last_name", nullable=false)
    private String lastName;

    @Column(name="email", unique=true, nullable=false)
    private String email;

    @OneToOne
    @JoinColumn(name = "payment_card_id", nullable = false)
    private PaymentCardEntity paymentCard;

    @ManyToOne
    @JoinColumn(name = "company_id", nullable = false)
    private CompanyEntity company;
}
