package com.getir.readingisgood.rest.mapper;

import com.getir.readingisgood.rest.model.StatisticsResponse;
import com.getir.readingisgood.service.model.OrderStatisticsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class OrderStatisticsMapper {
    public static final OrderStatisticsMapper INSTANCE = Mappers.getMapper(OrderStatisticsMapper.class);

    public abstract List<StatisticsResponse> toListOfStatisticsResponse(List<OrderStatisticsDto> orderStatisticsDtos);
}
