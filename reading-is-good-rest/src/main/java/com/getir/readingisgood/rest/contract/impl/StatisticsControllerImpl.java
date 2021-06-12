package com.getir.readingisgood.rest.contract.impl;

import com.getir.readingisgood.rest.contract.StatisticsController;
import com.getir.readingisgood.rest.mapper.OrderStatisticsMapper;
import com.getir.readingisgood.rest.model.StatisticsResponse;
import com.getir.readingisgood.service.contract.StatisticsService;
import com.getir.readingisgood.service.model.OrderStatisticsDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StatisticsControllerImpl implements StatisticsController {

    private final StatisticsService statisticsService;
    private OrderStatisticsMapper orderStatisticsMapper = OrderStatisticsMapper.INSTANCE;

    private static final Logger logger = LogManager.getLogger(StatisticsControllerImpl.class);

    @Autowired
    public StatisticsControllerImpl(StatisticsService statisticsService) {
        this.statisticsService = statisticsService;
    }

    @Override
    public ResponseEntity<List<StatisticsResponse>> getCustomerMonthlyStatistics(Long id) {
        final List<OrderStatisticsDto> orders = statisticsService.getStatisticsByCustomerId(id);
        logger.info("Customer {} orders retrieved by monthly",id);
        return ResponseEntity.ok(orderStatisticsMapper.toListOfStatisticsResponse(orders));
    }
}
