package com.auction.payment_service.dto;


import lombok.*;

import java.time.LocalDateTime;


@Builder
public record PaymentResponse(Long paymentId, String fullNameOnPaymentCard, String cardNumber, String expiringDate, String issueNumber, String securityNumber, Double amount, Long userId, Long productId, String paymentMethod, LocalDateTime paymentDate, boolean isSuccessful) {

}
