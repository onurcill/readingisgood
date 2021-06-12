package com.getir.readingisgood.rest.contract.impl;

import com.getir.readingisgood.rest.model.BookCreateRequest;
import com.getir.readingisgood.rest.contract.BookController;
import com.getir.readingisgood.rest.model.BookUpdateRequest;
import com.getir.readingisgood.rest.model.GenericResponse;
import com.getir.readingisgood.service.contract.BookService;
import com.getir.readingisgood.rest.mapper.BookMapper;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookControllerImpl implements BookController {
    private BookService bookService;

    private BookMapper bookMapper = BookMapper.INSTANCE;

    private static final Logger logger = LogManager.getLogger(BookControllerImpl.class);

    @Autowired
    public BookControllerImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public ResponseEntity<? extends GenericResponse> createBook(BookCreateRequest createOrUpdateBookRequest) {
        bookService.createBook(bookMapper.toBookDtoFromBookCreateUpdateRequest(createOrUpdateBookRequest));

        logger.info("Book Created successfully");

        return ResponseEntity.ok(GenericResponse.builder()
                .data(createOrUpdateBookRequest)
                .success(true)
                .message("Book Created.")
                .build());
    }

    @Override
    public ResponseEntity<? extends GenericResponse> updateBook(Long id, BookUpdateRequest bookUpdateRequest) {

        bookService.updateBook(id, bookMapper.toBookDtoFromBookUpdateRequest(bookUpdateRequest));
        logger.info("Book Updated successfully");
        return ResponseEntity.ok(GenericResponse.builder()
                .data(bookUpdateRequest)
                .success(true)
                .message("Book Updated.")
                .build());
    }
}
