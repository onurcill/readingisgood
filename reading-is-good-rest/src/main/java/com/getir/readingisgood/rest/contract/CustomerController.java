package com.getir.readingisgood.rest.contract;

import com.getir.readingisgood.rest.model.CustomerRequest;
import com.getir.readingisgood.rest.model.GenericResponse;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequestMapping("/api/v1/customers")
@Api(tags = "Customer")
public interface CustomerController {
    @PostMapping
    ResponseEntity<GenericResponse> createCustomer(@RequestBody @Valid CustomerRequest createCustomerDto);

    @GetMapping("/{id}")
    ResponseEntity<GenericResponse> getOrdersByCustomerId(@PathVariable Long id, Pageable pageable);
}
