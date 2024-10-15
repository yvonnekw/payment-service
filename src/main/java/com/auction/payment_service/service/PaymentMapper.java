package com.auction.payment_service.service;

import com.auction.payment_service.dto.PaymentRequest;
import com.auction.payment_service.model.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {

    public Payment toPayment(PaymentRequest request) {
        return Payment.builder()
                .paymentId(request.paymentId())
                .orderId(request.orderId())
                .paymentMethod(request.paymentMethod())
                .amount(request.amount())
                .build();
    }
}
