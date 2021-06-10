package com.getir.readingisgood.service.mapper;

import com.getir.readingisgood.service.model.BookDto;
import com.getir.readingisgood.data.model.BookEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class ServiceBookMapper {
    public static final ServiceBookMapper INSTANCE = Mappers.getMapper(ServiceBookMapper.class);
    public abstract BookEntity toBookEntityFromBookDto(BookDto bookDto);
    public abstract BookDto toBookDtoFromBookEntity(BookEntity bookEntity);
}
