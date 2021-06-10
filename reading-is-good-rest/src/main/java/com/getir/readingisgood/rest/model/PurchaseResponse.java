package com.getir.readingisgood.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
@AllArgsConstructor
public class PurchaseResponse {
    private String customerEmail;
    private OrderRequest order;
    private Set<OrderItemRequest> orderItems;
}
