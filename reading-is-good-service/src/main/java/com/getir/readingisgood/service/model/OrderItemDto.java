package com.getir.readingisgood.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
public class OrderItemDto {

    private int quantity;
    private BigDecimal unitPrice;
    private Long bookId;
    private OrderDto order;
}