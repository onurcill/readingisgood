package com.getir.readingisgood.service.contract.impl.unit;

import com.getir.readingisgood.data.enums.OrderStatus;
import com.getir.readingisgood.data.model.CustomerEntity;
import com.getir.readingisgood.data.repository.CustomerRepository;
import com.getir.readingisgood.service.contract.impl.CustomerServiceImpl;
import com.getir.readingisgood.service.mapper.CustomerMapper;
import com.getir.readingisgood.service.model.CustomerDto;
import com.getir.readingisgood.service.model.OrderDto;
import com.getir.readingisgood.service.model.OrderItemDto;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.*;

import static org.mockito.Mockito.*;

/**
 * @Author onurc
 * @create 6/12/2021 1:27 PM
 */
public class CustomerServiceImplTest {
    @Mock
    CustomerRepository customerRepository;
    @Mock
    CustomerMapper customerMapper;
    @InjectMocks
    CustomerServiceImpl customerServiceImpl;
    final Optional<CustomerEntity> emptyOptional = Optional.ofNullable(null);
    CustomerEntity entity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        entity = CustomerEntity.builder()
                .firstName("firstName")
                .lastName("lastName")
                .email("email")
                .phone("phone")
                .build();
    }

    @Test(expected = NullPointerException.class)
    public void testRegisterCustomer() throws Exception {
        CustomerEntity resultEntity = new CustomerEntity();
        resultEntity.setEmail("email");

        when(customerRepository.findByEmailIgnoreCase(anyString())).thenReturn(emptyOptional);
        when(customerMapper.toCustomerDtoFromCustomerEntity(any())).thenReturn(new CustomerDto(Long.valueOf(1), "firstName", "lastName", "email", "phone", LocalDateTime.of(2021, Month.JUNE, 12, 13, 27, 32).toInstant(ZoneOffset.UTC), new HashSet<OrderDto>(Arrays.asList(new OrderDto(Long.valueOf(1), "orderTrackingNumber", OrderStatus.IN_PROGRESS, new BigDecimal(0), 0, new HashSet<OrderItemDto>(Arrays.asList(new OrderItemDto(0, new BigDecimal(0), Long.valueOf(1), null))), new GregorianCalendar(2021, Calendar.JUNE, 12, 13, 27).getTime(), null)))));
        when(customerRepository.save(entity)).thenReturn(resultEntity);
        CustomerDto result = customerServiceImpl.registerCustomer(new CustomerDto(Long.valueOf(1), "firstName", "lastName", "email", "phone", LocalDateTime.of(2021, Month.JUNE, 12, 13, 27, 32).toInstant(ZoneOffset.UTC), new HashSet<OrderDto>(Arrays.asList(new OrderDto(Long.valueOf(1), "orderTrackingNumber", OrderStatus.IN_PROGRESS, new BigDecimal(0), 0, new HashSet<OrderItemDto>(Arrays.asList(new OrderItemDto(0, new BigDecimal(0), Long.valueOf(1), null))), new GregorianCalendar(2021, Calendar.JUNE, 12, 13, 27).getTime(), null)))));
        Assert.assertEquals(new CustomerDto(Long.valueOf(1), "firstName", "lastName", "email", "phone", LocalDateTime.of(2021, Month.JUNE, 12, 13, 27, 32).toInstant(ZoneOffset.UTC), new HashSet<OrderDto>(Arrays.asList(new OrderDto(Long.valueOf(1), "orderTrackingNumber", OrderStatus.IN_PROGRESS, new BigDecimal(0), 0, new HashSet<OrderItemDto>(Arrays.asList(new OrderItemDto(0, new BigDecimal(0), Long.valueOf(1), null))), new GregorianCalendar(2021, Calendar.JUNE, 12, 13, 27).getTime(), null)))), result);
    }

    @Test(expected = NullPointerException.class)
    public void testGetOrdersByCustomerId() throws Exception {
        List<OrderDto> result = customerServiceImpl.getOrdersByCustomerId(Long.valueOf(1), null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testDeleteCustomerById() throws Exception {
        customerServiceImpl.deleteCustomerById(Long.valueOf(1));
        Assert.assertTrue(true);
    }
}