package com.getir.readingisgood.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
@AllArgsConstructor
public class CustomerResponse {
    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final Instant registeredAt;
}
