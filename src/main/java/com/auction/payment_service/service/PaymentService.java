package com.auction.payment_service.service;


import com.auction.payment_service.dto.PaymentRequest;
import com.auction.payment_service.notification.NotificationProducer;
import com.auction.payment_service.notification.PaymentNotificationRequest;
import com.auction.payment_service.repository.PaymentRepository;
import com.auction.payment_service.service.PaymentMapper;
import lombok.*;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final PaymentMapper paymentMapper;
    private final NotificationProducer notificationProducer;
    public Long createPayment(PaymentRequest paymentRequestBody) {

        var payment = paymentRepository.save(paymentMapper.toPayment(paymentRequestBody));
        notificationProducer.sendNotification(
                new PaymentNotificationRequest(
                        paymentRequestBody.orderReference(),
                        paymentRequestBody.amount(),
                        paymentRequestBody.paymentMethod(),
                        paymentRequestBody.User().firstName(),
                        paymentRequestBody.User().lastName(),
                        paymentRequestBody.User().email()
                )
        );
        return payment.getPaymentId();
    }

    /*

    public List<PaymentResponse> getAllPayments() {
        return paymentRepository.findAll()
                .stream()
                //.map(payment -> new PaymentResponse(payment.getPaymentId(),  payment.getAmount(), payment.getPaymentMethod())
                .toList();
    }
*/
}
