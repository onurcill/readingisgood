package com.getir.readingisgood.service.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
public class OrderStatisticsDto {

    private long totalOrderCount;
    private BigDecimal totalPrice;
    private long totalQuantity;
    private int month;
}
