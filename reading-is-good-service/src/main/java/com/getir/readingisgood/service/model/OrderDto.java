package com.getir.readingisgood.service.model;

import com.getir.readingisgood.data.enums.OrderStatus;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto{

    private Long id;
    private String orderTrackingNumber;
    private OrderStatus status;
    private BigDecimal totalPrice;
    private int totalQuantity;
    private Set<OrderItemDto> orderItems;
    private Date dateCreated;
    private CustomerDto customer;
}