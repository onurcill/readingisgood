package com.getir.readingisgood.rest.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Builder
@Getter
@Setter
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

