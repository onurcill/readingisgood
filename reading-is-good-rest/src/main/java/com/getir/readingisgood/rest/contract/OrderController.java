package com.getir.readingisgood.rest.contract;

import com.getir.readingisgood.rest.model.GenericResponse;
import com.getir.readingisgood.rest.model.OrderResponse;
import com.getir.readingisgood.rest.model.PurchaseRequest;
import com.getir.readingisgood.rest.model.PurchaseResponse;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDateTime;
import java.util.List;

@Validated
@RequestMapping("/api/v1/orders")
@Api(tags = "Order")
public interface OrderController {
    @PostMapping
    ResponseEntity<GenericResponse> processOrder(@RequestBody @Valid PurchaseRequest purchaseRequest);

    @GetMapping("/{id}")
    ResponseEntity<GenericResponse> getOrderById(@PathVariable Long id);

    @GetMapping
    ResponseEntity<GenericResponse> getOrdersByDateInterval(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime startDate,
                                                                @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime endDate, Pageable pageable);
}
