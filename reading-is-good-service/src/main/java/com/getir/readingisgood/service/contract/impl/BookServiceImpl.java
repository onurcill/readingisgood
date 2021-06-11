package com.getir.readingisgood.service.contract.impl;

import com.getir.readingisgood.service.contract.BookService;
import com.getir.readingisgood.service.enums.ErrorEnum;
import com.getir.readingisgood.service.exception.ResourceNotFoundException;
import com.getir.readingisgood.service.mapper.ServiceBookMapper;
import com.getir.readingisgood.service.model.BookDto;
import com.getir.readingisgood.data.model.BookEntity;
import com.getir.readingisgood.data.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final ServiceBookMapper serviceBookMapper = ServiceBookMapper.INSTANCE;

    @Autowired
    public BookServiceImpl(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    @Transactional
    public void createBook(BookDto bookDto) {
        bookRepository.save(serviceBookMapper.toBookEntityFromBookDto(bookDto));
    }

    @Override
    public void updateBook(Long id, BookDto bookDto) {
        Optional<BookEntity> bookFromDb = Optional.ofNullable(
                bookRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.BOOK_NOT_FOUND, id)));

        bookFromDb.get().setUnitsInStock(bookDto.getUnitsInStock());
        bookRepository.save(bookFromDb.get());
    }
}
