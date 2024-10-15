package com.auction.payment_service.controller;

import com.auction.payment_service.dto.PaymentResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.auction.payment_service.service.*;
import com.auction.payment_service.dto.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController {


    private final PaymentService paymentService;

    @PostMapping("/create-payment")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Long> createPayment(@RequestBody @Valid PaymentRequest paymentRequest) {
        return ResponseEntity.ok(paymentService.createPayment(paymentRequest));
    }
/*
    @GetMapping("/get-all-payments")
    @ResponseStatus(HttpStatus.OK)
    public List<PaymentResponse> getAllPayments() {
        return paymentService.getAllPayments();
    }
*/
    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getPayment() {
        return "payment api working ";
    }


}
