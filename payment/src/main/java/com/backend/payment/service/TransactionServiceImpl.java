package com.backend.payment.service;

import com.backend.payment.dto.PaymentCard;
import com.backend.payment.dto.Transaction;
import com.backend.payment.dto.TransactionResponseDTO;
import com.backend.payment.exception.EntityDoesNotExistsException;
import com.backend.payment.exception.InsufficientBalanceException;
import com.backend.payment.model.*;
import com.backend.payment.repository.TransactionRepository;
import com.backend.payment.service.serviceInterface.BenefitService;
import com.backend.payment.service.serviceInterface.PaymentCardService;
import com.backend.payment.service.serviceInterface.TransactionService;
import com.backend.payment.service.serviceInterface.UserService;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
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
                .description("Success")
                .transactionStatus(TransactionStatus.SUCCESS)
                .build();
        try {
            switch (user.getPaymentCard().getCardType()) {
                case STANDARD:
                    CompanyBenefit companyBenefit = checkIfBenefitInCompanyBenefits(user, benefitEntity);
                    if (companyBenefit == null) {
                        throw new EntityDoesNotExistsException("Benefit not in company benefits");
                    }
                    break;
                case PREMIUM:
                    break;
                case PLATINUM:
                    CompanyBenefit platinumCompanyBenefit = checkIfBenefitInCompanyBenefits(user, benefitEntity);
                    if (platinumCompanyBenefit != null) {
                        long discountedValue = (transaction.getValue() * (1 - platinumCompanyBenefit.getDiscount()));
                        transaction.setValue(discountedValue);
                    }
                    break;
                default:
                    throw new EntityDoesNotExistsException("Card type does not exist");
            }
            paymentCardService.balanceUpdate(user.getPaymentCard(),transaction.getValue());
            return saveTransaction(transaction);
        }catch (EntityDoesNotExistsException | InsufficientBalanceException ex) {
            transaction.setTransactionStatus(TransactionStatus.FAILURE);
            transaction.setDescription(ex.getMessage());
            saveTransaction(transaction);
            throw ex;
        }
    }

    @Override
    public List<TransactionResponseDTO> getByStatus(TransactionStatus status) {
        List<TransactionEntity> entities = transactionRepository.findByTransactionStatus(status);
        List<TransactionResponseDTO> responseDTOs = new ArrayList<>();

        for (TransactionEntity entity : entities) {
            PaymentCard paymentCard = PaymentCard.builder()
                    .cardType(entity.getPaymentCard().getCardType())
                    .balance(entity.getPaymentCard().getBalance())
                    .build();
            TransactionResponseDTO responseDTO = TransactionResponseDTO.builder()
                    .benefitName(entity.getBenefit().getName())
                    .benefitCategory(entity.getBenefit().getBenefitCategory().getCategoryName())
                    .value(entity.getValue())
                    .description(entity.getDescription())
                    .transactionStatus(entity.getTransactionStatus())
                    .paymentCard(paymentCard)
                    .build();

            responseDTOs.add(responseDTO);
        }

        return responseDTOs;
    }

    private CompanyBenefit checkIfBenefitInCompanyBenefits(UserEntity user, BenefitEntity benefitEntity) {
        return user.getCompany().getCompanyBenefits().stream()
                .filter(companyBenefit -> companyBenefit.getBenefit().getName().equals(benefitEntity.getName())
                        && companyBenefit.getBenefit().getBenefitCategory().getCategoryName().equals(benefitEntity.getBenefitCategory().getCategoryName()))
                .findFirst()
                .orElse(null);
    }
    @Transactional
    public Integer saveTransaction(TransactionEntity entity){
        return transactionRepository.save(entity).getId();
    }
}
