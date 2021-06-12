package com.getir.readingisgood.rest.contract.impl;

import com.getir.readingisgood.rest.contract.OrderController;
import com.getir.readingisgood.rest.mapper.OrderMapper;
import com.getir.readingisgood.rest.model.GenericResponse;
import com.getir.readingisgood.rest.model.PurchaseRequest;
import com.getir.readingisgood.service.contract.OrderService;
import com.getir.readingisgood.service.model.OrderDto;
import com.getir.readingisgood.service.model.PurchaseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
public class OrderControllerImpl implements OrderController {

    private OrderMapper orderMapper = OrderMapper.INSTANCE;
    private final OrderService orderService;

    private static final Logger logger = LogManager.getLogger(OrderControllerImpl.class);

    @Autowired
    public OrderControllerImpl(OrderService orderService) {
        this.orderService = orderService;
    }

    @Override
    public ResponseEntity<GenericResponse> processOrder(PurchaseRequest purchaseRequest) {
        PurchaseDto purchase = orderMapper.toPurchaseDto(purchaseRequest);
        purchase = orderService.placeOrder(purchase);
        logger.info("Order placed from {}",purchaseRequest.getCustomer().getFirstName());

        return ResponseEntity.ok(GenericResponse.builder()
                .data(orderMapper.toPurchaseResponse(purchase))
                .success(true)
                .message("Order placed")
                .build());
    }

    @Override
    public ResponseEntity<GenericResponse> getOrderById(Long id) {
        OrderDto order = orderService.getOrderById(id);
        logger.info("Order information retrieved {}",order.getId());

        return ResponseEntity.ok(GenericResponse.builder()
                .data(orderMapper.toOrderResponse(order))
                .success(true)
                .message("Order info is returned")
                .build());
    }

    @Override
    public ResponseEntity<GenericResponse> getOrdersByDateInterval(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        List<OrderDto> orders = orderService.getOrdersByDateInterval(startDate, endDate, pageable);
        logger.info("All Order information retrieved between {} and {}",startDate,endDate);
        return ResponseEntity.ok(GenericResponse.builder()
                .data(orderMapper.toPageOrderResponseFromOrderDto(orders))
                .success(true)
                .message("Order info is returned for given dates")
                .build());
    }
}
