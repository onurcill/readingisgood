package com.getir.readingisgood.service.contract.impl.unit;

import com.getir.readingisgood.data.model.BookEntity;
import com.getir.readingisgood.data.repository.BookRepository;
import com.getir.readingisgood.service.contract.impl.BookServiceImpl;
import com.getir.readingisgood.service.exception.ResourceNotFoundException;
import com.getir.readingisgood.service.mapper.ServiceBookMapper;
import com.getir.readingisgood.service.model.BookDto;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.*;

/**
 * @Author onurc
 * @create 6/12/2021 1:16 PM
 */
public class BookServiceImplTest {
    @Mock
    BookRepository bookRepository;
    @Mock
    ServiceBookMapper serviceBookMapper;
    @InjectMocks
    BookServiceImpl bookServiceImpl;
    BookDto bookDto;
    BookEntity bookEntity;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        bookDto = new BookDto(Long.valueOf(1), "name", "description", new BigDecimal(0), 0, new GregorianCalendar(2021, Calendar.JUNE, 12, 13, 16).getTime(), new GregorianCalendar(2021, Calendar.JUNE, 12, 13, 16).getTime());
        bookEntity = new BookEntity(Long.valueOf(1), "name", "description", new BigDecimal(0), 0, new GregorianCalendar(2021, Calendar.JUNE, 12, 13, 16).getTime(), new GregorianCalendar(2021, Calendar.JUNE, 12, 13, 16).getTime());
    }

    @Test
    public void testCreateBook() throws Exception {
        when(serviceBookMapper.toBookEntityFromBookDto(any())).thenReturn(bookEntity);

        bookServiceImpl.createBook(bookDto);
        Assert.assertTrue(true);
    }

    @Test(expected = ResourceNotFoundException.class)
    public void testUpdateBook() throws Exception {

        bookServiceImpl.updateBook(Long.valueOf(1), bookDto);
    }
}