package com.getir.readingisgood.service.contract;

import com.getir.readingisgood.data.model.BookEntity;
import com.getir.readingisgood.service.model.BookDto;

public interface BookService {
    BookDto createBook(BookDto bookDto);
    BookDto updateBook(Long id, BookDto bookDto);
}
