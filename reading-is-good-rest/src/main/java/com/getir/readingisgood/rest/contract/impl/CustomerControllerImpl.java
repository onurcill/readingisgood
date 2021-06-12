package com.getir.readingisgood.rest.contract.impl;

import com.getir.readingisgood.rest.contract.CustomerController;
import com.getir.readingisgood.rest.mapper.CustomerMapper;
import com.getir.readingisgood.rest.mapper.OrderMapper;
import com.getir.readingisgood.rest.model.CustomerRequest;
import com.getir.readingisgood.rest.model.CustomerResponse;
import com.getir.readingisgood.rest.model.OrderResponse;
import com.getir.readingisgood.service.contract.CustomerService;
import com.getir.readingisgood.service.model.CustomerDto;
import com.getir.readingisgood.service.model.OrderDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@RestController
public class CustomerControllerImpl implements CustomerController {

    private CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private OrderMapper orderMapper = OrderMapper.INSTANCE;
    private final CustomerService customerService;
    private static final Logger logger = LogManager.getLogger(CustomerControllerImpl.class);

    @Autowired
    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    @Transactional
    public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest customerCreateRequest) {
        final CustomerDto customerDto = customerService.registerCustomer(customerMapper.toCustomerDtoFromCustomerRequest(customerCreateRequest));
        logger.info("Customer created : FirstName is {}, LastName is {}",customerDto.getFirstName(),customerDto.getLastName());
        return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toCustomerResponseFromCustomerDto(customerDto));
    }

    @Override
    public ResponseEntity<List<OrderResponse>> getOrdersByCustomerId(Long id, Pageable pageable) {
        final List<OrderDto> orders = customerService.getOrdersByCustomerId(id, pageable);
        return ResponseEntity.ok(orderMapper.toPageOrderResponseFromOrderDto(orders));
    }
}
