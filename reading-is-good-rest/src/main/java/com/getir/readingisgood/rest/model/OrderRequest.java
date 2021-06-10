package com.getir.readingisgood.rest.model;

import com.getir.readingisgood.data.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Builder
@Getter
@AllArgsConstructor
public class OrderRequest {
    private String orderTrackingNumber;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private int totalQuantity;
}
