package com.getir.readingisgood.service.model;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@Getter
@Builder
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDto{

    private Long id;
    private String name;
    private String description;
    private BigDecimal unitPrice;
    private int unitsInStock;
    private Date dateCreated;
    private Date lastUpdated;
}