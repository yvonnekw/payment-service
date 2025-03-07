package com.auction.payment_service.controller;

import com.auction.payment_service.model.Payment;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.auction.payment_service.service.*;
import com.auction.payment_service.dto.*;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/process-payment")
    public ResponseEntity<PaymentResponse> processPayment(
            @RequestHeader("Authorization") String token,
            @RequestHeader("X-Username") String username,
            @RequestHeader("X-FirstName") String firstName,
            @RequestHeader("X-LastName") String lastName,
            @RequestHeader("X-Email") String email,
            @RequestBody OrderPaymentRequest orderPaymentRequest) {

        log.info("Received payment request for user: {}, {}, {}, {}, {}", username, firstName, lastName, email, orderPaymentRequest);

        return paymentService.processPayment(username, firstName, lastName, email, orderPaymentRequest);
    }

    /*
    @PostMapping("/process-payment")
    public PaymentResponse processPayment(
            @RequestHeader("Authorization") String token,
            @RequestHeader("X-Username") String username,
            @RequestHeader("X-FirstName") String firstName,
            @RequestHeader("X-LastName") String lastName,
            @RequestHeader("X-Email") String email,
            @RequestBody PaymentRequest paymentRequest) {

        log.info("Received payment request for user: {}, {}, {}, {}", username, firstName, lastName, email);

        PaymentResponse paymentResponse = paymentService.processPayment(username, firstName, lastName, email, paymentRequest);

        //return ResponseEntity.ok(paymentService.processPayment(username, firstName, lastName, email, paymentRequest));
        return ResponseEntity.ok(paymentResponse);
    }
*/

    /*
    @PostMapping("/create-payment")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> createPayment(@RequestBody @Valid PaymentRequest paymentRequest) {
        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
    }

     */

    @GetMapping("/get-all-payments")
    @ResponseStatus(HttpStatus.OK)
    public List<Payment> getAllPayments(@RequestHeader("Authorization") String token) {

        return paymentService.getAllPayments();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getPayment() {
        return "payment api working ";
    }


}
