package com.getir.readingisgood.service.mapper;

import com.getir.readingisgood.data.model.CustomerEntity;
import com.getir.readingisgood.service.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;


@Mapper
public abstract class CustomerMapper {
    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    public abstract CustomerDto toCustomerDtoFromCustomerEntity(CustomerEntity entity);
}

