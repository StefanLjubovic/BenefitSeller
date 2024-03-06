package com.backend.payment.dto;

import com.backend.payment.model.PaymentCardEntity;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class User {

    private String firstName;

    private String lastName;

    private String email;

    private PaymentCard paymentCard;
}
