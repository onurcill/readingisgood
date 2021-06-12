package com.getir.readingisgood.rest.contract.impl;

import com.getir.readingisgood.rest.contract.AuthController;

import com.getir.readingisgood.service.contract.AuthorizationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthControllerImpl implements AuthController {

    private AuthorizationService authorizationService;

    @Autowired
    public AuthControllerImpl(AuthorizationService authorizationService) {
        this.authorizationService = authorizationService;
    }

    private static final Logger logger = LogManager.getLogger(AuthControllerImpl.class);

    @Override
    public ResponseEntity<String> login(String email, String pwd) {
        String token = authorizationService.getJWTToken(email);
        logger.info("Customer: {} logged in with token {}", email, token);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }
}
