package com.getir.readingisgood.rest.mapper;

import com.getir.readingisgood.rest.model.CustomerRequest;
import com.getir.readingisgood.rest.model.CustomerResponse;
import com.getir.readingisgood.service.model.CustomerDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class CustomerMapper {
    public static final CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);
    public abstract CustomerDto toCustomerDtoFromCustomerRequest(CustomerRequest request);
    public abstract CustomerResponse toCustomerResponseFromCustomerDto(CustomerDto customerDto);
}
