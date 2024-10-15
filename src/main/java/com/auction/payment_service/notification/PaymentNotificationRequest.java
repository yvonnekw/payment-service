package com.auction.payment_service.notification;

import com.auction.payment_service.model.PaymentMethod;

import java.math.BigDecimal;

public record PaymentNotificationRequest(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        String userFirstName,
        String userLastName,
        String userEmail
) {
}
