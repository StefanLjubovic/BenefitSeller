package com.backend.payment.dto;

import com.backend.payment.model.TransactionStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TransactionResponseDTO {

    private String benefitName;

    private String benefitCategory;

    private Long value;

    private String description;

    private TransactionStatus transactionStatus;

    private PaymentCard paymentCard;
}
