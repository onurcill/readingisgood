package com.getir.readingisgood.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Set;

@Getter
@Builder
@Setter
public class CustomerDto {

    private final Long id;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;
    private final Instant registeredAt;
    private Set<OrderDto> orders;
}