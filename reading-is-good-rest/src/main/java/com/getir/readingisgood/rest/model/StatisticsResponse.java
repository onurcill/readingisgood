package com.getir.readingisgood.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
@AllArgsConstructor
public class StatisticsResponse {
    private long totalOrderCount;
    private BigDecimal totalPrice;
    private long totalQuantity;
    private int month;
}
