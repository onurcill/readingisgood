package com.getir.readingisgood.service.contract;

import com.getir.readingisgood.service.model.CustomerDto;

public interface CustomerService {
    CustomerDto registerCustomer(CustomerDto createCustomerDto);
}
