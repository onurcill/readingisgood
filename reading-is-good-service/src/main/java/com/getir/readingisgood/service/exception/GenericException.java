package com.getir.readingisgood.service.exception;

import java.util.Objects;

public abstract class GenericException extends RuntimeException {
    private final String field;
    private final String code;
    private final String message;

    protected GenericException(String errorCode, String message) {
        this("", errorCode, message);
    }

    protected GenericException(String field, String errorCode, String message) {
        super(message);
        Objects.requireNonNull(errorCode);
        this.code = errorCode;
        this.field = field;
        this.message = message;
    }

    public String getField() {
        return this.field;
    }

    public String getCode() {
        return this.code;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}