package com.auction.payment_service.controller;

import com.auction.payment_service.dto.InvoiceRequest;
import com.auction.payment_service.dto.InvoiceResponse;
import com.auction.payment_service.dto.PaymentRequest;
import com.auction.payment_service.dto.PaymentResponse;
import com.auction.payment_service.service.InvoiceService;
import com.auction.payment_service.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoice")
@RequiredArgsConstructor
public class InvoiceController {


    private final InvoiceService invoiceService;

    @PostMapping("/create-invoice")
    @ResponseStatus(HttpStatus.CREATED)
    public InvoiceResponse createInvoice(@RequestBody InvoiceRequest invoiceRequest) {
        return invoiceService.createInvoice(invoiceRequest);
    }

    @GetMapping("/get-all-invoices")
    @ResponseStatus(HttpStatus.OK)
    public List<InvoiceResponse> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public String getPayment() {
        return "payment api working ";
    }


}
