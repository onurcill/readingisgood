package com.getir.readingisgood.rest.contract;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Validated
@RequestMapping("/api/v1/authorization")
@Api(tags = "Authorization")
public interface AuthController {

    @PostMapping
    String login(@RequestParam("email") String email, @RequestParam("password") String pwd);
}
