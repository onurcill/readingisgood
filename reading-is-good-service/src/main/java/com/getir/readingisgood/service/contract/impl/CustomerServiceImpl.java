package com.getir.readingisgood.service.contract.impl;

import com.getir.readingisgood.data.model.CustomerEntity;
import com.getir.readingisgood.data.repository.CustomerRepository;
import com.getir.readingisgood.service.contract.CustomerService;
import com.getir.readingisgood.service.enums.ErrorEnum;
import com.getir.readingisgood.service.exception.BadRequestException;
import com.getir.readingisgood.service.mapper.CustomerMapper;
import com.getir.readingisgood.service.mapper.ServiceBookMapper;
import com.getir.readingisgood.service.model.CustomerDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements CustomerService {

    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public CustomerDto registerCustomer(CustomerDto createCustomerDto) {
        if (customerRepository.findByEmailIgnoreCase(createCustomerDto.getEmail()).isPresent()) {
            throw new BadRequestException(ErrorEnum.CUSTOMER_ALREADY_EXISTS, createCustomerDto.getEmail());
        }
        final CustomerEntity customer = customerRepository.save(CustomerEntity.builder()
                .firstName(createCustomerDto.getFirstName())
                .lastName(createCustomerDto.getLastName())
                .email(createCustomerDto.getEmail())
                .phone(createCustomerDto.getPhone())
                .build());

        logger.info("Customer with email '{}' has been created.", customer.getEmail());

        return customerMapper.toCustomerDtoFromCustomerEntity(customer);
    }
}
