package com.backend.payment;

import com.backend.payment.dto.Transaction;
import com.backend.payment.model.*;

import java.util.Arrays;
import java.util.Collections;

public class Constants {

    public static UserEntity createUser() {
        BenefitEntity benefitEntity1 = createBenefit("restaurants", "Food and drinks");
        BenefitEntity benefitEntity2 = createBenefit("fitness", "Recreation");

        CompanyBenefit companyBenefit1 = CompanyBenefit.builder().benefit(benefitEntity1).build();
        CompanyBenefit companyBenefit2 = CompanyBenefit.builder().benefit(benefitEntity2).build();

        return UserEntity.builder()
                .firstName("John")
                .lastName("Doe")
                .email("john.doe@example.com")
                .paymentCard(PaymentCardEntity.builder()
                        .balance(1000L)
                        .cardType(CardType.STANDARD)
                        .build())
                .company(CompanyEntity.builder()
                        .name("Example Company")
                        .companyBenefits(Arrays.asList(companyBenefit1, companyBenefit2))
                        .build())
                .build();
    }

    public static BenefitEntity createBenefit(String name,String category) {
        return  BenefitEntity.builder()
                .benefitCategory(BenefitCategory.builder().categoryName(category).build())
                .name(name)
                .build();
    }

    public static Transaction createTransaction(String benefitName,Long value){
        return  Transaction.builder()
                .value(value)
                .benefitName(benefitName)
                .email("john.doe@example.com")
                .category("Food and drinks")
                .build();

    }
}

