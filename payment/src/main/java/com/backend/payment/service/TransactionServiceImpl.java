package com.backend.payment.service;

import com.backend.payment.dto.Transaction;
import com.backend.payment.exception.EntityDoesNotExistsException;
import com.backend.payment.model.BenefitEntity;
import com.backend.payment.model.CompanyBenefit;
import com.backend.payment.model.TransactionEntity;
import com.backend.payment.model.UserEntity;
import com.backend.payment.repository.TransactionRepository;
import com.backend.payment.service.serviceInterface.BenefitService;
import com.backend.payment.service.serviceInterface.PaymentCardService;
import com.backend.payment.service.serviceInterface.TransactionService;
import com.backend.payment.service.serviceInterface.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
@Transactional
public class TransactionServiceImpl implements TransactionService {

    private final TransactionRepository transactionRepository;
    private final UserService userService;
    private final BenefitService benefitService;
    private final PaymentCardService paymentCardService;

    @Override
    public Integer save(Transaction transactionDto) {
        UserEntity user = userService.findByEmail(transactionDto.getEmail());
        BenefitEntity benefitEntity = benefitService.findByCategoryAndName(transactionDto.getCategory(),transactionDto.getBenefitName());
        TransactionEntity transaction = TransactionEntity.builder()
                .value(transactionDto.getValue())
                .paymentCard(user.getPaymentCard())
                .benefit(benefitEntity)
                .build();
        switch (user.getPaymentCard().getCardType()){
            case STANDARD:
                CompanyBenefit companyBenefit=checkIfBenefitInCompanyBenefits(user, benefitEntity);
                if(companyBenefit == null) {
                    throw new EntityDoesNotExistsException("Benefit not in company benefits");
                }
                break;
            case PREMIUM:
                break;
            case PLATINUM:
                CompanyBenefit platinumCompanyBenefit=checkIfBenefitInCompanyBenefits(user, benefitEntity);
                if (platinumCompanyBenefit != null) {
                    transaction.setValue(transaction.getValue() * platinumCompanyBenefit.getDiscount());
                }
                break;
            default:
                throw new EntityDoesNotExistsException("Card type does not exist");
        }
        paymentCardService.balanceUpdate(user.getPaymentCard(),transaction.getValue());
        return saveTransaction(transaction);
    }

    private CompanyBenefit checkIfBenefitInCompanyBenefits(UserEntity user, BenefitEntity benefitEntity) {
        return user.getCompany().getCompanyBenefits().stream()
                .filter(companyBenefit -> companyBenefit.getBenefit().getName().equals(benefitEntity.getName())
                        && companyBenefit.getBenefit().getBenefitCategory().getCategoryName().equals(benefitEntity.getBenefitCategory().getCategoryName()))
                .findFirst()
                .orElse(null);
    }

    public Integer saveTransaction(TransactionEntity entity){
        return transactionRepository.save(entity).getId();
    }
}
