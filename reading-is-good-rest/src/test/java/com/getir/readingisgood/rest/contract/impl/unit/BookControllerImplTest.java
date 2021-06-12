package com.getir.readingisgood.rest.contract.impl.unit;

import com.getir.readingisgood.rest.contract.impl.BookControllerImpl;
import com.getir.readingisgood.rest.mapper.BookMapper;
import com.getir.readingisgood.rest.model.BookCreateRequest;
import com.getir.readingisgood.rest.model.BookUpdateRequest;
import com.getir.readingisgood.service.contract.BookService;
import com.getir.readingisgood.service.model.BookDto;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.*;

/**
 * @Author onurc
 * @create 6/12/2021 3:04 PM
 */
public class BookControllerImplTest {
    @Mock
    BookService bookService;
    @Mock
    BookMapper bookMapper;
    @InjectMocks
    BookControllerImpl bookControllerImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testCreateBook() throws Exception {
        when(bookMapper.toBookDtoFromBookCreateUpdateRequest(any())).thenReturn(new BookDto(Long.valueOf(1), "name", "description", new BigDecimal(0), 0, new GregorianCalendar(2021, Calendar.JUNE, 12, 15, 4).getTime(), new GregorianCalendar(2021, Calendar.JUNE, 12, 15, 4).getTime()));
        ResponseEntity<?> result = bookControllerImpl.createBook(new BookCreateRequest("name", "description", new BigDecimal(0), 0));
        Assert.assertEquals(200, result.getStatusCode().value());
    }

    @Test
    public void testUpdateBook() throws Exception {
        when(bookMapper.toBookDtoFromBookUpdateRequest(any())).thenReturn(new BookDto(Long.valueOf(1), "name", "description", new BigDecimal(0), 0, new GregorianCalendar(2021, Calendar.JUNE, 12, 15, 4).getTime(), new GregorianCalendar(2021, Calendar.JUNE, 12, 15, 4).getTime()));

        ResponseEntity<?> result = bookControllerImpl.updateBook(Long.valueOf(1), new BookUpdateRequest(0));
        Assert.assertEquals(200, result.getStatusCode().value());
    }
}