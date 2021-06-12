package com.getir.readingisgood.service.contract;

import com.getir.readingisgood.service.model.CustomerDto;
import com.getir.readingisgood.service.model.OrderDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface CustomerService {
    CustomerDto registerCustomer(CustomerDto createCustomerDto);

    List<OrderDto> getOrdersByCustomerId(Long id, Pageable pageable);

    void deleteCustomerById(Long id);
}
