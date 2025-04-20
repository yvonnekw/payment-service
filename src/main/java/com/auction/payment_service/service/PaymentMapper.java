package com.auction.payment_service.service;

import com.auction.payment_service.dto.OrderPaymentRequest;
import com.auction.payment_service.model.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class PaymentMapper {

    public Payment toPayment(OrderPaymentRequest request, String username) {
        log.info("Payment request in toPayment, {},{},{},", request.getOrderRequest().totalAmount(), request.getPaymentRequest().paymentMethod(), request.getOrderRequest().orderReference());
        return Payment.builder()
                .orderReference(request.getOrderRequest().orderReference())
                .paymentMethod(request.getPaymentRequest().paymentMethod())
                .amount(request.getOrderRequest().totalAmount())
                .username(username)
                .build();
    }
}
