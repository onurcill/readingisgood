package com.getir.readingisgood.rest.model;

import lombok.*;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest {

    @NotNull(message = "Firstname cannot be empty")
    private String firstName;

    @NotNull(message = "Lastname cannot be empty")
    private String lastName;

    @NotNull(message = "Please provide a valid email address")
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
    private String email;

    @NotNull(message = "Phone cannot be null")
    private String phone;

}