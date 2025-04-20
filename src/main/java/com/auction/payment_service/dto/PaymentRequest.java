package com.auction.payment_service.dto;

import com.auction.payment_service.model.PaymentMethod;
import lombok.*;

import java.math.BigDecimal;

@Builder
public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        boolean isSuccessful) {

}
