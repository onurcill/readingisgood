package com.getir.readingisgood.rest.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class SuccessResponse implements Serializable {
    private String code;
    private String returnCode;
    private String messageText;

    public SuccessResponse(String code, String returnCode, String messageText) {
        this.code = code;
        this.returnCode = returnCode;
        this.messageText = messageText;
    }
}
