package com.backend.payment.service;

import com.backend.payment.Constants;
import com.backend.payment.dto.Transaction;
import com.backend.payment.exception.EntityDoesNotExistsException;
import com.backend.payment.model.BenefitEntity;
import com.backend.payment.model.TransactionEntity;
import com.backend.payment.model.TransactionStatus;
import com.backend.payment.model.UserEntity;
import com.backend.payment.repository.TransactionRepository;
import com.backend.payment.service.serviceInterface.BenefitService;
import com.backend.payment.service.serviceInterface.TransactionService;
import com.backend.payment.service.serviceInterface.UserService;
import org.junit.Rule;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class TransactionServiceTest {

    @Mock
    private TransactionRepository transactionRepository;

    @Mock
    private UserService userService;

    @Mock
    private BenefitService benefitService;

    @InjectMocks
    private TransactionServiceImpl transactionService;

    @Test
    public void testSaveTransactionBenefitInCompanyBenefitsNotFound() {
        UserEntity userEntity= Constants.createUser();
        BenefitEntity benefitEntity= Constants.createBenefit("random","benefit");
        Transaction transaction=Constants.createTransaction("restaurants",1000L);
        TransactionEntity savedTransactionEntity = TransactionEntity.builder().transactionStatus(TransactionStatus.FAILURE).build();

        when(userService.findByEmail(anyString())).thenReturn(userEntity);
        when(benefitService.findByCategoryAndName(anyString(), anyString())).thenReturn(benefitEntity);
        when(transactionRepository.save(any())).thenReturn(savedTransactionEntity);

        Exception exception = assertThrows(EntityDoesNotExistsException.class, () -> {
            transactionService.save(transaction);
        });
        String expectedMessage = "Benefit not in company benefits";
        assertTrue(exception.getMessage().contains(expectedMessage));
    }

}
