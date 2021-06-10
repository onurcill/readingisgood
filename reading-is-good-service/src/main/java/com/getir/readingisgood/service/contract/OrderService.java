package com.getir.readingisgood.service.contract;

import com.getir.readingisgood.service.model.OrderDto;
import com.getir.readingisgood.service.model.PurchaseDto;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    PurchaseDto placeOrder(PurchaseDto purchase);

    OrderDto getOrderById(Long id);

    List<OrderDto> getOrdersByCustomerId(Long id, Pageable pageable);

    List<OrderDto> getOrdersByDateInterval(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable);
}
