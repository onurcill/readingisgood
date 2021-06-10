package com.getir.readingisgood.service.exception;

import com.getir.readingisgood.service.enums.ErrorEnum;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends GenericException {

    public BadRequestException(ErrorEnum error, Object... parameters) {
        super(error.getErrorCode(), String.format(error.getErrorMessage(), parameters));
    }
}