package com.getir.readingisgood.rest.contract.impl;

import com.getir.readingisgood.rest.contract.AuthController;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AuthControllerImpl implements AuthController {

    private static final Logger logger = LogManager.getLogger(AuthControllerImpl.class);

    @Override
    public ResponseEntity<String> login(String email, String pwd) {
        String token = getJWTToken(email);
        logger.debug("Customer: {} logged in with token {}", email, token);
        return ResponseEntity.status(HttpStatus.OK).body(token);
    }

    private String getJWTToken(String username) {
        String secretKey = "readingIsGoodSecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils
                .commaSeparatedStringToAuthorityList("ROLE_USER");

        String token = Jwts
                .builder()
                .setId("readingisgoodJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }
}
