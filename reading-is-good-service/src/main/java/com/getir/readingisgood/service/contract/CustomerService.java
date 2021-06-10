package com.getir.readingisgood.service.contract;

import com.getir.readingisgood.service.model.CustomerDto;
import com.getir.readingisgood.service.model.OrderDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CustomerService {
    CustomerDto registerCustomer(CustomerDto createCustomerDto);

    Page<OrderDto> getOrdersByCustomerId(Long id, Pageable pageable);

    void deleteCustomerById(Long id);
}
