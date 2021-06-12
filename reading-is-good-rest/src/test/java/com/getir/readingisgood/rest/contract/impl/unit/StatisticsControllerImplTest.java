package com.getir.readingisgood.rest.contract.impl.unit;

import com.getir.readingisgood.rest.contract.impl.StatisticsControllerImpl;
import com.getir.readingisgood.rest.mapper.OrderStatisticsMapper;
import com.getir.readingisgood.rest.model.StatisticsResponse;
import com.getir.readingisgood.service.contract.StatisticsService;
import com.getir.readingisgood.service.model.OrderStatisticsDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.*;

/**
 * @Author onurc
 * @create 6/12/2021 3:09 PM
 */
public class StatisticsControllerImplTest {
    @Mock
    StatisticsService statisticsService;
    @Mock
    OrderStatisticsMapper orderStatisticsMapper;
    @InjectMocks
    StatisticsControllerImpl statisticsControllerImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetCustomerMonthlyStatistics() throws Exception {
        when(statisticsService.getStatisticsByCustomerId(anyLong())).thenReturn(Arrays.<OrderStatisticsDto>asList(new OrderStatisticsDto()));
        when(orderStatisticsMapper.toListOfStatisticsResponse(any())).thenReturn(Arrays.<StatisticsResponse>asList(new StatisticsResponse(0L, new BigDecimal(0), 0L, 0)));

        ResponseEntity<List<StatisticsResponse>> result = statisticsControllerImpl.getCustomerMonthlyStatistics(Long.valueOf(1));
        Assert.assertEquals(200, result.getStatusCode().value());
    }
}