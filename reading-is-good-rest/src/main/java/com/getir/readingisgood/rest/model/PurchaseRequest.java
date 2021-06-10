package com.getir.readingisgood.rest.model;

import com.getir.readingisgood.service.model.CustomerDto;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Builder
public class PurchaseRequest {

    @NotNull(message = "Please send customer info.")
    private CustomerDto customer;
    @NotNull(message = "Order cannot be null.")
    private OrderRequest order;
    @NotNull(message = "OrderItems cannot be null")
    private Set<OrderItemRequest> orderItems;
}