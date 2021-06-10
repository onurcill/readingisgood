package com.getir.readingisgood.service.model;

import com.getir.readingisgood.data.model.CustomerEntity;
import com.getir.readingisgood.data.model.OrderEntity;
import com.getir.readingisgood.data.model.OrderItemEntity;
import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Getter
@Builder
public class PurchaseDto {

    private CustomerEntity customer;
    private OrderEntity order;
    private Set<OrderItemEntity> orderItems;
}