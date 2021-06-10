package com.getir.readingisgood.rest.contract;

import com.getir.readingisgood.rest.model.BookCreateRequest;
import com.getir.readingisgood.rest.model.BookUpdateRequest;
import com.getir.readingisgood.rest.model.SuccessResponse;
import com.getir.readingisgood.service.model.BookDto;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Validated
@RequestMapping("/api/v1/books")
@Api(tags = "Book")
public interface BookController {
    @PostMapping
    ResponseEntity<SuccessResponse> createBook(@RequestBody @Valid BookCreateRequest createOrUpdateBookRequest);
    @PatchMapping("/{id}")
    ResponseEntity<SuccessResponse> updateBook(@PathVariable Long id,
                                                @RequestBody @Valid BookUpdateRequest bookUpdateRequest);
}
