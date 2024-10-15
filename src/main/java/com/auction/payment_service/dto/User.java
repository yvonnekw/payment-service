package com.auction.payment_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record User(
        Long userId,
        @NotNull(message = "Firstname is require.")
        String firstName,
        @NotNull(message = "Lastname is require.")
        String lastName,
        @NotNull(message = "Email is require.")
        @Email(message = "The user's email is not correctly formatted.")
        String email
) {
}
