package com.getir.readingisgood.rest.contract.impl;

import com.getir.readingisgood.rest.contract.CustomerController;
import com.getir.readingisgood.rest.mapper.BookMapper;
import com.getir.readingisgood.rest.mapper.CustomerMapper;
import com.getir.readingisgood.rest.model.CustomerRequest;
import com.getir.readingisgood.rest.model.CustomerResponse;
import com.getir.readingisgood.service.contract.CustomerService;
import com.getir.readingisgood.service.model.CustomerDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CustomerControllerImpl implements CustomerController {

    private CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private final CustomerService customerService;
    private static final Logger logger = LogManager.getLogger(CustomerControllerImpl.class);

    @Autowired
    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Override
    public ResponseEntity<CustomerResponse> createCustomer(CustomerRequest customerCreateRequest) {
        final CustomerDto customerDto = customerService.registerCustomer(customerMapper.toCustomerDtoFromCustomerRequest(customerCreateRequest));
        return ResponseEntity.status(HttpStatus.CREATED).body(customerMapper.toCustomerResponseFromCustomerDto(customerDto));
    }
}
