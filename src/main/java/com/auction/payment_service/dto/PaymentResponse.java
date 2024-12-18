package com.auction.payment_service.dto;


import lombok.*;

import java.time.LocalDateTime;


@Builder
public record PaymentResponse(
        Long paymentId,
        String fullNameOnPaymentCard,
        String cardNumber,
        String expiringDate,
        String issueNumber,
        String securityNumber,
        Double amount,
        //String username,
        Long productId,
        String paymentMethod,
        LocalDateTime paymentDate,
        boolean isSuccessful) {

}
