package com.getir.readingisgood.rest.mapper;

import com.getir.readingisgood.rest.model.OrderResponse;
import com.getir.readingisgood.service.model.OrderDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public abstract class OrderMapper {
    public static final OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);

    public abstract List<OrderResponse> toPageOrderResponseFromOrderDto(List<OrderDto> orderDto);
}
