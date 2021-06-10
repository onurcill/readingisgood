package com.getir.readingisgood.rest.model;

import com.getir.readingisgood.data.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Builder
@AllArgsConstructor
public class OrderResponse {

    private Long id;
    private String orderTrackingNumber;
    private int totalQuantity;
    private BigDecimal totalPrice;
    private OrderStatus status;
    private Date dateCreated;
    private Date lastUpdated;
    private String customerEmail;

}