package com.getir.readingisgood.rest.contract.impl;

import com.getir.readingisgood.rest.contract.OrderController;
import com.getir.readingisgood.rest.mapper.OrderMapper;
import com.getir.readingisgood.rest.model.OrderResponse;
import com.getir.readingisgood.rest.model.PurchaseRequest;
import com.getir.readingisgood.rest.model.PurchaseResponse;
import com.getir.readingisgood.service.contract.OrderService;
import com.getir.readingisgood.service.model.OrderDto;
import com.getir.readingisgood.service.model.PurchaseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OrderControllerImpl implements OrderController {

    private OrderMapper orderMapper = OrderMapper.INSTANCE;
    private final OrderService orderService;

    @Autowired
    public OrderControllerImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<PurchaseResponse> processOrder(PurchaseRequest purchaseRequest) {
        PurchaseDto purchase = orderMapper.toPurchaseDto(purchaseRequest);
        purchase = orderService.placeOrder(purchase);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(orderMapper.toPurchaseResponse(purchase));
    }

    @Override
    public ResponseEntity<OrderResponse> getOrderById(Long id) {
        final OrderDto order = orderService.getOrderById(id);
        return ResponseEntity.ok(orderMapper.toOrderResponse(order));
    }

    @Override
    public ResponseEntity<List<OrderResponse>> getOrdersByDateInterval(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        final List<OrderDto> orders = orderService.getOrdersByDateInterval(startDate, endDate, pageable);
        return ResponseEntity.ok(orderMapper.toPageOrderResponseFromOrderDto(orders));
    }
}
