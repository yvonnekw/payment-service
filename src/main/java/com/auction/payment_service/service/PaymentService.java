package com.auction.payment_service.service;


import com.auction.payment_service.dto.OrderPaymentRequest;
import com.auction.payment_service.dto.PaymentResponse;
import com.auction.payment_service.model.Payment;
import com.auction.payment_service.notification.NotificationProducer;
import com.auction.payment_service.notification.PaymentNotificationRequest;
import com.auction.payment_service.repository.PaymentRepository;
import lombok.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;

    public ResponseEntity<PaymentResponse> processPayment(
            String username,
            String firstName,
            String lastName,
            String email,
            OrderPaymentRequest orderPaymentRequestBody) {

        var payment = paymentRepository.save(paymentMapper.toPayment(orderPaymentRequestBody, username));

        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        orderPaymentRequestBody.getOrderRequest().orderReference(),
                        orderPaymentRequestBody.getOrderRequest().totalAmount(),
                        orderPaymentRequestBody.getPaymentRequest().paymentMethod(),
                        username,
                        firstName,
                        lastName,
                        email
                )
        );

        PaymentResponse paymentResponse = PaymentResponse.builder()
                .orderId(payment.getPaymentId())
                .amount(orderPaymentRequestBody.getOrderRequest().totalAmount())
                .isSuccessful(true)
                .build();

        return ResponseEntity.ok(paymentResponse);
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                .toList();
    }

}
