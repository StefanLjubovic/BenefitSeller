package com.backend.payment.service;

import com.backend.payment.exception.EntityDoesNotExistsException;
import com.backend.payment.model.BenefitEntity;
import com.backend.payment.repository.BenefitRepository;
import com.backend.payment.service.serviceInterface.BenefitService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class BenefitServiceImpl implements BenefitService {

    private final BenefitRepository benefitRepository;

    @Override
    public BenefitEntity findByCategoryAndName(String category, String name) {
        return benefitRepository.findByBenefitCategory_CategoryNameAndName(category,name)
                .orElseThrow(() -> new EntityDoesNotExistsException("Benefit does not exist"));
    }
}
