package com.getir.readingisgood.rest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class BookCreateRequest {

    @NotNull(message = "Please provide a name")
    private String name;
    @NotNull(message = "Please provide a description")
    private String description;
    @NotNull(message = "Please provide price")
    private BigDecimal unitPrice;
    @NotNull(message = "Please provide stock number")
    private int unitsInStock;

}

