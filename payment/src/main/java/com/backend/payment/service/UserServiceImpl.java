package com.backend.payment.service;


import com.backend.payment.dto.PaymentCard;
import com.backend.payment.dto.User;
import com.backend.payment.exception.EntityDoesNotExistsException;
import com.backend.payment.model.UserEntity;
import com.backend.payment.repository.UserRepository;
import com.backend.payment.service.serviceInterface.UserService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    @Override
    public UserEntity findByEmail(String username) {
        return userRepository.findByEmail(username)
                .orElseThrow(() -> new EntityDoesNotExistsException("User with this email does not exist"));
    }

    @Override
    public User getCardFunds(String email) {
        UserEntity userEntity=findByEmail(email);

        PaymentCard paymentCard= PaymentCard.builder()
                .balance(userEntity.getPaymentCard().getBalance())
                .cardType(userEntity.getPaymentCard().getCardType())
                .build();

        return User.builder()
                .email(email)
                .firstName(userEntity.getFirstName())
                .lastName(userEntity.getLastName())
                .paymentCard(paymentCard)
                .build();
    }

}
