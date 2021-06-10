package com.getir.readingisgood.service.mapper;

import com.getir.readingisgood.data.model.OrderEntity;
import com.getir.readingisgood.data.model.OrderStatistics;
import com.getir.readingisgood.service.model.OrderDto;
import com.getir.readingisgood.service.model.OrderStatisticsDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class OrderMapper {
    public static final OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    public abstract OrderDto toOrderDtoFromOrderEntity(OrderEntity entity);
    public abstract List<OrderDto> toOrderDtoPage(List<OrderEntity> entities);
    public abstract List<OrderStatisticsDto> toOrderStatisticsDtoList(List<OrderStatistics> orderStatistics);
}

