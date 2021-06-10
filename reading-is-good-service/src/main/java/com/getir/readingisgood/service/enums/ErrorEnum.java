package com.getir.readingisgood.service.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ErrorEnum {
    CUSTOMER_ALREADY_EXISTS("customerAlreadyExists",
                                    "Customer could not be created. Customer with the email %s already exists."),
    CUSTOMER_NOT_FOUND("customerNotFound", "Customer: '%s' not found."),
    BOOK_NOT_FOUND("bookNotFound", "Book: '%s' not found."),
    BOOK_STOCK_NOT_ENOUGH("bookStockNotEnough", "Book cannot be purchased, stocks should be renewed."),
    ORDER_NOT_FOUND("orderNotFound", "Order: '%s' not found.");

    private final String errorCode;
    private final String errorMessage;
}
