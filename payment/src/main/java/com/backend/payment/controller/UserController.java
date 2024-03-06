package com.backend.payment.controller;

import com.backend.payment.dto.User;
import com.backend.payment.service.serviceInterface.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@ControllerAdvice
@RequestMapping(value = "/user")
public class UserController {

    private  final UserService userService;

    @GetMapping("/funds/{email}")
    @ResponseStatus(HttpStatus.OK)
    public User getCardFunds(@PathVariable String email){
        return userService.getCardFunds(email);
    }
}
