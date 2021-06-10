package com.getir.readingisgood.service.contract.impl;

import com.getir.readingisgood.data.model.OrderStatistics;
import com.getir.readingisgood.data.repository.OrderRepository;
import com.getir.readingisgood.service.contract.StatisticsService;
import com.getir.readingisgood.service.mapper.OrderMapper;
import com.getir.readingisgood.service.model.OrderStatisticsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper = OrderMapper.INSTANCE;

    @Autowired
    public StatisticsServiceImpl(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    @Override
    public List<OrderStatisticsDto> getStatisticsByCustomerId(Long id) {
        List<OrderStatistics> statistics = orderRepository.findStatisticsByCustomerId(id);
        return orderMapper.toOrderStatisticsDtoList(statistics);
    }
}
