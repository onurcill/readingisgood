package com.getir.readingisgood.service.model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemDto {

    private int quantity;
    private BigDecimal unitPrice;
    private Long bookId;
    private OrderDto order;
}