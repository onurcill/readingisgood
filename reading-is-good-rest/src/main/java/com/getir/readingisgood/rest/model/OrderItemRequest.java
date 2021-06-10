package com.getir.readingisgood.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class OrderItemRequest {
    private int quantity;
    private BigDecimal unitPrice;
    private Long bookId;
}

