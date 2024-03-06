package com.backend.payment.service.serviceInterface;

import com.backend.payment.model.PaymentCardEntity;
import com.backend.payment.model.UserEntity;

public interface PaymentCardService {

    void balanceUpdate(PaymentCardEntity paymentCardEntity, Long transactionValue);
}
