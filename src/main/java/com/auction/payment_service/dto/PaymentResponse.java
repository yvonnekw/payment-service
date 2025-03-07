package com.auction.payment_service.dto;


import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;


@Builder
public record PaymentResponse(
        Long orderId,
        BigDecimal amount,
        boolean isSuccessful) {

}
