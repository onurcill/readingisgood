package com.getir.readingisgood.service.contract.impl.unit;

import com.getir.readingisgood.data.model.OrderStatistics;
import com.getir.readingisgood.data.repository.OrderRepository;
import com.getir.readingisgood.service.contract.impl.StatisticsServiceImpl;
import com.getir.readingisgood.service.mapper.OrderMapper;
import com.getir.readingisgood.service.model.OrderStatisticsDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author onurc
 * @create 6/12/2021 1:54 PM
 */
public class StatisticsServiceImplTest {
    @Mock
    OrderRepository orderRepository;
    @Mock
    OrderMapper orderMapper;
    @InjectMocks
    StatisticsServiceImpl statisticsServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetStatisticsByCustomerId() throws Exception {
        when(orderRepository.findStatisticsByCustomerId(anyLong())).thenReturn(Arrays.<OrderStatistics>asList(new OrderStatistics(0L, new BigDecimal(0), 0L, 0)));
        when(orderMapper.toOrderStatisticsDtoList(any())).thenReturn(Arrays.<OrderStatisticsDto>asList(new OrderStatisticsDto()));

        List<OrderStatisticsDto> result = statisticsServiceImpl.getStatisticsByCustomerId(Long.valueOf(1));
        Assert.assertNotNull(result);
    }
}