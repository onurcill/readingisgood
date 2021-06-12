package com.getir.readingisgood.service.contract.impl;

import com.getir.readingisgood.data.model.OrderStatistics;
import com.getir.readingisgood.data.repository.OrderRepository;
import com.getir.readingisgood.service.contract.StatisticsService;
import com.getir.readingisgood.service.mapper.OrderMapper;
import com.getir.readingisgood.service.model.OrderStatisticsDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final OrderRepository orderRepository;
    private OrderMapper orderMapper = OrderMapper.INSTANCE;

    private static final Logger logger = LogManager.getLogger(StatisticsServiceImpl.class);

    @Autowired
    public StatisticsServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderStatisticsDto> getStatisticsByCustomerId(Long id) {
        List<OrderStatistics> statistics = orderRepository.findStatisticsByCustomerId(id);
        logger.info("Customer {} monthly orders retrieved",id);
        return orderMapper.toOrderStatisticsDtoList(statistics);
    }
}
