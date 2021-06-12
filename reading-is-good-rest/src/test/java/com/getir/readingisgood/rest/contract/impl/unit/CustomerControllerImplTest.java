package com.getir.readingisgood.rest.contract.impl.unit;

import com.getir.readingisgood.data.enums.OrderStatus;
import com.getir.readingisgood.rest.contract.impl.CustomerControllerImpl;
import com.getir.readingisgood.rest.mapper.CustomerMapper;
import com.getir.readingisgood.rest.mapper.OrderMapper;
import com.getir.readingisgood.rest.model.CustomerResponse;
import com.getir.readingisgood.rest.model.GenericResponse;
import com.getir.readingisgood.rest.model.OrderResponse;
import com.getir.readingisgood.service.contract.CustomerService;
import com.getir.readingisgood.service.model.CustomerDto;
import com.getir.readingisgood.service.model.OrderDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.*;

import static org.mockito.Mockito.*;

/**
 * @Author onurc
 * @create 6/12/2021 3:08 PM
 */
public class CustomerControllerImplTest {
    @Mock
    CustomerMapper customerMapper;
    @Mock
    OrderMapper orderMapper;
    @Mock
    CustomerService customerService;
    @InjectMocks
    CustomerControllerImpl customerControllerImpl;
    Optional<OrderDto> dtoOptional;
    OrderDto orderDto;
    List<OrderDto> orderDtos;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        orderDto = new OrderDto();
        orderDto.setId(Long.valueOf(1));
        dtoOptional = Optional.of(orderDto);

        orderDtos = new ArrayList<>();

        orderDtos.add(orderDto);
    }

    @Test
    public void testCreateCustomer() throws Exception {
        when(customerMapper.toCustomerDtoFromCustomerRequest(any())).thenReturn(new CustomerDto(Long.valueOf(1), "firstName", "lastName", "email", "phone", LocalDateTime.of(2021, Month.JUNE, 12, 15, 8, 16).toInstant(ZoneOffset.UTC), new HashSet<OrderDto>(Arrays.asList(new OrderDto()))));
        when(customerMapper.toCustomerResponseFromCustomerDto(any())).thenReturn(new CustomerResponse(Long.valueOf(1), "firstName", "lastName", "email", "phone", LocalDateTime.of(2021, Month.JUNE, 12, 15, 8, 16).toInstant(ZoneOffset.UTC)));
        when(customerService.registerCustomer(any())).thenReturn(new CustomerDto(Long.valueOf(1), "firstName", "lastName", "email", "phone", LocalDateTime.of(2021, Month.JUNE, 12, 15, 8, 16).toInstant(ZoneOffset.UTC), new HashSet<OrderDto>(Arrays.asList(new OrderDto()))));

        ResponseEntity<GenericResponse> result = customerControllerImpl.createCustomer(null);
        Assert.assertEquals(201, result.getStatusCode().value());
    }

    @Test
    public void testGetOrdersByCustomerId() throws Exception {
        Page<OrderDto> pagedResponse = new PageImpl(orderDtos);

        when(orderMapper.toPageOrderResponseFromOrderDto(any())).thenReturn(Arrays.<OrderResponse>asList(new OrderResponse(Long.valueOf(1), "orderTrackingNumber", 0, new BigDecimal(0), OrderStatus.IN_PROGRESS, new GregorianCalendar(2021, Calendar.JUNE, 12, 15, 8).getTime(), new GregorianCalendar(2021, Calendar.JUNE, 12, 15, 8).getTime(), "customerEmail")));
        when(customerService.getOrdersByCustomerId(anyLong(), any())).thenReturn(orderDtos);

        ResponseEntity<GenericResponse> result = customerControllerImpl.getOrdersByCustomerId(Long.valueOf(1), null);
        Assert.assertEquals(200, result.getStatusCode().value());
    }
}