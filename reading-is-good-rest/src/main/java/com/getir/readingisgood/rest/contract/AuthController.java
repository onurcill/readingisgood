package com.getir.readingisgood.rest.contract;

import com.getir.readingisgood.rest.model.GenericResponse;
import io.swagger.annotations.Api;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@RequestMapping("/api/v1/authorization")
@Api(tags = "Authorization")
public interface AuthController {

    @PostMapping
    ResponseEntity<GenericResponse> login(@RequestParam("email") String email, @RequestParam("password") String pwd);
}
