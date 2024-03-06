package com.backend.payment.repository;

import com.backend.payment.model.PaymentCardEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentCardRepository extends JpaRepository<PaymentCardEntity,Integer> {
}
