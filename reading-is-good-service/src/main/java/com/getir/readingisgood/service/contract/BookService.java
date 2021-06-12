package com.getir.readingisgood.service.contract;

import com.getir.readingisgood.service.model.BookDto;

public interface BookService {

    void createBook(BookDto bookDto);

    void updateBook(Long id, BookDto bookDto);
}
