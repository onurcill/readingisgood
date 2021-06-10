package com.getir.readingisgood.rest.contract;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;

@Validated
@RequestMapping("/api/v1/orders")
public interface OrderController {
}
