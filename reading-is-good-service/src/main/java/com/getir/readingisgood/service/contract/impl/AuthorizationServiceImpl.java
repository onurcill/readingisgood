package com.getir.readingisgood.service.contract.impl;

import com.getir.readingisgood.service.contract.AuthorizationService;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author onurc
 * @create 6/12/2021 5:15 PM
 */
@Service
public class AuthorizationServiceImpl implements AuthorizationService {

    private static final Logger logger = LogManager.getLogger(AuthorizationServiceImpl.class);

    @Value("${jwt.secret.key}")
    private String secretKey;

    @Override
    public String getJWTToken(String username) {
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
        logger.info("JWT Token returned successfully");

        return "Bearer " + token;
    }
}
