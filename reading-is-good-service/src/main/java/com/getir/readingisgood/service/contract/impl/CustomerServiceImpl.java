package com.getir.readingisgood.service.contract.impl;

import com.getir.readingisgood.data.model.CustomerEntity;
import com.getir.readingisgood.data.repository.CustomerRepository;
import com.getir.readingisgood.service.contract.CustomerService;
import com.getir.readingisgood.service.contract.OrderService;
import com.getir.readingisgood.service.enums.ErrorEnum;
import com.getir.readingisgood.service.exception.BadRequestException;
import com.getir.readingisgood.service.mapper.CustomerMapper;
import com.getir.readingisgood.service.mapper.ServiceBookMapper;
import com.getir.readingisgood.service.model.CustomerDto;
import com.getir.readingisgood.service.model.OrderDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final OrderService orderService;
    private final CustomerMapper customerMapper = CustomerMapper.INSTANCE;
    private static final Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

    @Autowired
    public CustomerServiceImpl(CustomerRepository customerRepository, OrderService orderService) {
        this.customerRepository = customerRepository;
        this.orderService = orderService;
    }

    @Override
    public CustomerDto registerCustomer(CustomerDto createCustomerDto) {
        if (customerRepository.findByEmailIgnoreCase(createCustomerDto.getEmail()).isPresent()) {
            logger.error("Exception is occured exception message is {}",ErrorEnum.CUSTOMER_ALREADY_EXISTS);
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

    @Override
    public List<OrderDto> getOrdersByCustomerId(Long id, Pageable pageable) {
        return this.orderService.getOrdersByCustomerId(id, pageable);
    }

    @Transactional
    public void deleteCustomerById(Long id) {
        customerRepository.findById(id).ifPresent(this::deleteCustomer);
    }
    private void deleteCustomer(CustomerEntity customerEntity) {
        customerRepository.delete(customerEntity);
        logger.info("User '{}' has been deleted.", customerEntity.getEmail());
    }
}
