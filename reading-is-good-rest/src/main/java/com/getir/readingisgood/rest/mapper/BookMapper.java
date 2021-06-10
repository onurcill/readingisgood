package com.getir.readingisgood.rest.mapper;

import com.getir.readingisgood.rest.model.BookCreateRequest;
import com.getir.readingisgood.rest.model.BookUpdateRequest;
import com.getir.readingisgood.service.model.BookDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public abstract class BookMapper {
    public static final BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
    public abstract BookDto toBookDtoFromBookCreateUpdateRequest(BookCreateRequest request);
    public abstract BookDto toBookDtoFromBookUpdateRequest(BookUpdateRequest request);
}
