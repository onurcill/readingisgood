package com.getir.readingisgood.service.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
public class OrderDto extends DateDto{

    private String orderTrackingNumber;
    private BigDecimal totalPrice;
    private int totalQuantity;
    private Set<OrderItemDto> orderItems;
    private CustomerDto customer;
}