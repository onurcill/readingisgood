package com.getir.readingisgood.rest.model;

import com.getir.readingisgood.rest.model.error.ApiError;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GenericResponse<T> {
    private boolean success;
    private String message;
    private T data;
    private ApiError apiError;
}