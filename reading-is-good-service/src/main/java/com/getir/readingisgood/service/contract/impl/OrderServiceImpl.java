package com.getir.readingisgood.service.contract.impl;

import com.getir.readingisgood.data.model.CustomerEntity;
import com.getir.readingisgood.data.model.OrderEntity;
import com.getir.readingisgood.data.model.OrderItemEntity;
import com.getir.readingisgood.data.repository.BookRepository;
import com.getir.readingisgood.data.repository.CustomerRepository;
import com.getir.readingisgood.data.repository.OrderRepository;
import com.getir.readingisgood.service.contract.OrderService;
import com.getir.readingisgood.service.enums.ErrorEnum;
import com.getir.readingisgood.service.exception.BookStockException;
import com.getir.readingisgood.service.exception.ResourceNotFoundException;
import com.getir.readingisgood.service.mapper.OrderMapper;
import com.getir.readingisgood.service.model.OrderDto;
import com.getir.readingisgood.service.model.PurchaseDto;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    private final BookRepository bookRepository;
    private final CustomerRepository customerRepository;
    private final OrderRepository orderRepository;
    private OrderMapper orderMapper = OrderMapper.INSTANCE;

    private static final Logger logger = LogManager.getLogger(OrderServiceImpl.class);

    @Autowired
    public OrderServiceImpl(BookRepository bookRepository, CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.bookRepository = bookRepository;
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional
    public PurchaseDto placeOrder(PurchaseDto purchase) {
        OrderEntity order = purchase.getOrder();

        String orderTrackingNumber = generateOrderTrackingNumber();
        logger.info("Order Tracking Number created: {}", orderTrackingNumber);
        order.setOrderTrackingNumber(orderTrackingNumber);

        Set<OrderItemEntity> orderItems = purchase.getOrderItems();
        orderItems.forEach(item -> {
            Long bookId = item.getBookId();

            Optional.ofNullable(bookRepository.findById(bookId)
                    .orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.BOOK_NOT_FOUND, bookId))).ifPresent(book -> {
                int quantity = book.getUnitsInStock() - item.getQuantity();
                if (quantity < 0) {
                    logger.error("Book stock is over for book id: {}", book.getId());
                    throw new BookStockException(ErrorEnum.BOOK_STOCK_NOT_ENOUGH);
                }
                book.setUnitsInStock(quantity);
                bookRepository.save(book);
                logger.info("Book is purchased and stock amount: {}, stock updated for book id: {}", quantity, bookId);
                order.add(item);
            });
        });

        CustomerEntity customerFromDb = customerRepository.findByEmailIgnoreCase(purchase.getCustomer().getEmail()).orElseThrow(
                () -> new ResourceNotFoundException(ErrorEnum.CUSTOMER_NOT_FOUND, purchase.getCustomer().getEmail()));
        logger.info("Customer: {}", customerFromDb);

        customerFromDb.add(order);

        customerRepository.save(customerFromDb);
        logger.info("Customer with email successfully purchased {}:", customerFromDb.getEmail());

        return PurchaseDto.builder()
                .customer(customerFromDb)
                .order(order)
                .orderItems(order.getOrderItems()).build();
    }

    @Override
    public OrderDto getOrderById(Long id) {
        OrderEntity entity = orderRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ErrorEnum.ORDER_NOT_FOUND, id));
        return orderMapper.toOrderDtoFromOrderEntity(entity);
    }

    @Override
    public List<OrderDto> getOrdersByCustomerId(Long id, Pageable pageable) {
        Page<OrderEntity> orderEntityList = orderRepository.findAllByCustomerId(id, pageable);
        return orderMapper.toOrderDtoPage(orderEntityList.getContent());
    }

    @Override
    public List<OrderDto> getOrdersByDateInterval(LocalDateTime startDate, LocalDateTime endDate, Pageable pageable) {
        Date startDateTime = Date.from(startDate.toInstant(ZoneOffset.UTC));
        Date endDateTime = Date.from(endDate.toInstant(ZoneOffset.UTC));

        Page<OrderEntity> orderEntities = orderRepository.findAllByDateCreatedIsBetween(startDateTime, endDateTime, pageable);
        logger.info("All orders retrieved between {} and {}", startDate,endDate);
        return orderMapper.toOrderDtoPage(orderEntities.getContent());
    }

    private String generateOrderTrackingNumber() {
        return UUID.randomUUID().toString();
    }
}
