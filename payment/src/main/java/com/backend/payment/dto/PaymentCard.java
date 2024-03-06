package com.backend.payment.dto;

import com.backend.payment.model.CardType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class PaymentCard {

    private Long balance;

    private CardType cardType;
}
