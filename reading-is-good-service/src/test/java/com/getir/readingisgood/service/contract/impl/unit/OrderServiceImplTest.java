package com.getir.readingisgood.service.contract.impl.unit;

import com.getir.readingisgood.data.model.OrderEntity;
import com.getir.readingisgood.data.repository.BookRepository;
import com.getir.readingisgood.data.repository.CustomerRepository;
import com.getir.readingisgood.data.repository.OrderRepository;
import com.getir.readingisgood.service.contract.impl.OrderServiceImpl;
import com.getir.readingisgood.service.mapper.OrderMapper;
import com.getir.readingisgood.service.model.OrderDto;
import com.getir.readingisgood.service.model.PurchaseDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;

import static org.mockito.Mockito.*;

/**
 * @Author onurc
 * @create 6/12/2021 1:56 PM
 */
public class OrderServiceImplTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    CustomerRepository customerRepository;
    @Mock
    OrderRepository orderRepository;
    @Mock
    OrderMapper orderMapper;
    @InjectMocks
    OrderServiceImpl orderServiceImpl;

    OrderEntity entity;
    Optional<OrderEntity> entityOptional;
    List<OrderDto> list;
    List<OrderEntity> orderEntities;



    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        entity = new OrderEntity();
        entity.setId(Long.valueOf(1));
        entityOptional = Optional.of(entity);
        list = new ArrayList<>();
        orderEntities = new ArrayList<>();
        orderEntities.add(entity);

    }

    @Test(expected = NullPointerException.class)
    public void testPlaceOrder() throws Exception {
        when(customerRepository.findByEmailIgnoreCase(anyString())).thenReturn(null);

        PurchaseDto result = orderServiceImpl.placeOrder(null);
        Assert.assertEquals(null, result);
    }

    @Test
    public void testGetOrderById() throws Exception {

        when(orderRepository.findById(Long.valueOf("1"))).thenReturn(entityOptional);
        when(orderMapper.toOrderDtoFromOrderEntity(entity)).thenReturn(new OrderDto());

        OrderDto result = orderServiceImpl.getOrderById(Long.valueOf(1));
        Assert.assertEquals(Long.valueOf(1), result.getId());
    }

    @Test
    public void testGetOrdersByCustomerId() throws Exception {
        Pageable pageable = null;
        Page<OrderEntity> pagedResponse = new PageImpl(orderEntities);
        when(orderRepository.findAllByCustomerId(anyLong(), any())).thenReturn(pagedResponse);
        when(orderMapper.toOrderDtoPage(any())).thenReturn(list);

        List<OrderDto> result = orderServiceImpl.getOrdersByCustomerId(Long.valueOf(1), pageable);
        Assert.assertNotNull(result);
    }

    @Test
    public void testGetOrdersByDateInterval() throws Exception {
        Pageable pageable = null;
        Page<OrderEntity> pagedResponse = new PageImpl(orderEntities);
        when(orderRepository.findAllByDateCreatedIsBetween(any(), any(), any())).thenReturn(pagedResponse);
        List<OrderDto> orderDtoList = new ArrayList<>();
        when(orderMapper.toOrderDtoPage(any())).thenReturn(orderDtoList);

        List<OrderDto> result = orderServiceImpl.getOrdersByDateInterval(LocalDateTime.of(2021, Month.JUNE, 12, 13, 56, 58), LocalDateTime.of(2021, Month.JUNE, 12, 13, 56, 58), null);
        Assert.assertNotNull(result);
    }
}