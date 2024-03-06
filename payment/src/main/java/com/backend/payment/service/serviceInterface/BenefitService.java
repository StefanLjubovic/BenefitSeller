package com.backend.payment.service.serviceInterface;

import com.backend.payment.model.BenefitEntity;

public interface BenefitService {

    BenefitEntity findByCategoryAndName(String category,String name);
}
