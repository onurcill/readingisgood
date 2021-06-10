package com.getir.readingisgood.rest.contract;

import com.getir.readingisgood.rest.model.CustomerRequest;
import com.getir.readingisgood.rest.model.CustomerResponse;
import com.getir.readingisgood.rest.model.OrderResponse;
import io.swagger.annotations.Api;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RequestMapping("/api/v1/customers")
@Api(tags = "Customer")
public interface CustomerController {
    @PostMapping
    ResponseEntity<CustomerResponse> createCustomer(@RequestBody @Valid CustomerRequest createCustomerDto);

    @GetMapping("/{id}")
    ResponseEntity<List<OrderResponse>> getOrdersByCustomerId(@PathVariable Long id, Pageable pageable);
}
