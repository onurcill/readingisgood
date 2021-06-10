package com.getir.readingisgood.service.contract;

import com.getir.readingisgood.service.model.OrderStatisticsDto;

import java.util.List;

public interface StatisticsService {
    List<OrderStatisticsDto> getStatisticsByCustomerId(Long id);
}
