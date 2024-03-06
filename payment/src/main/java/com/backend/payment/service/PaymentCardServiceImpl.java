package com.backend.payment.service;

import com.backend.payment.exception.InsufficientBalanceException;
import com.backend.payment.model.PaymentCardEntity;
import com.backend.payment.repository.PaymentCardRepository;
import com.backend.payment.service.serviceInterface.PaymentCardService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class PaymentCardServiceImpl implements PaymentCardService {

    private  final PaymentCardRepository paymentCardRepository;
    @Override
    public void balanceUpdate(PaymentCardEntity paymentCardEntity, Long transactionValue) {
        paymentCardEntity.setBalance(paymentCardEntity.getBalance() - transactionValue);
        if(paymentCardEntity.getBalance()<0){
            throw new InsufficientBalanceException("Not enough funds for this transaction");
        }
        paymentCardRepository.save(paymentCardEntity);
    }
}
