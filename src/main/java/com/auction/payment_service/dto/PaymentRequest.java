package com.auction.payment_service.dto;

import com.auction.payment_service.model.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/*
future developemtn -

   String cardNumber,
        String expiringDate,
        String issueNumber,
        String securityNumber,
 */
@Builder
public record PaymentRequest(
        //Long paymentId,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Long orderId,
        String orderReference,
       // User User,
        LocalDateTime createdDate,
        LocalDateTime lastModifiedDate,
        boolean isSuccessful) {

}
