package com.getir.readingisgood.data.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatistics {

    private long totalOrderCount;
    private BigDecimal totalPrice;
    private long totalQuantity;
    private int month;
}