package com.getir.readingisgood.rest.contract.impl;

import com.getir.readingisgood.rest.model.BookCreateRequest;
import com.getir.readingisgood.rest.contract.BookController;
import com.getir.readingisgood.rest.model.BookUpdateRequest;
import com.getir.readingisgood.rest.model.SuccessResponse;
import com.getir.readingisgood.service.contract.BookService;
import com.getir.readingisgood.rest.mapper.BookMapper;
import com.getir.readingisgood.service.exception.ResourceNotFoundException;
import com.getir.readingisgood.service.model.BookDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<SuccessResponse> createBook(BookCreateRequest createOrUpdateBookRequest) {
        try{
            BookDto response = bookService.createBook(bookMapper.toBookDtoFromBookCreateUpdateRequest(createOrUpdateBookRequest));
            logger.info("Book Created successfully");
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new SuccessResponse("500","500","Getting Error while add a new book"));
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(new SuccessResponse("201","201","New Book added"));
    }

    @Override
    public ResponseEntity<SuccessResponse> updateBook(Long id, BookUpdateRequest bookUpdateRequest) {
        try {
            final BookDto book = bookService.updateBook(id, bookMapper.toBookDtoFromBookUpdateRequest(bookUpdateRequest));
            logger.info("Book Updated successfully");
        }catch (ResourceNotFoundException e){
            logger.error("Getting error while update a book id: {}",id);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new SuccessResponse("400","400","Getting Error while update a book"));
        }
        return ResponseEntity.status(HttpStatus.OK).body(new SuccessResponse("200","200","Book updated successfully"));
    }
}
