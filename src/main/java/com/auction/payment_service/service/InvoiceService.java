package com.auction.payment_service.service;


import com.auction.payment_service.dto.InvoiceRequest;
import com.auction.payment_service.dto.InvoiceResponse;
import com.auction.payment_service.dto.PaymentResponse;
import com.auction.payment_service.model.Invoice;
import com.auction.payment_service.repository.InvoiceRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;

    public InvoiceResponse createInvoice(InvoiceRequest invoiceRequestBody) {

        Invoice invoice = Invoice.builder()
                .invoiceId(invoiceRequestBody.invoiceId())
                .invoiceDate(invoiceRequestBody.invoiceDate())
                .paymentId(invoiceRequestBody.paymentId())
                .invoiceNumber(invoiceRequestBody.invoiceNumber())
                .build();
        invoiceRepository.save(invoice);
        log.info("invoice with id {} is saved. ", invoice.getInvoiceId());
        return  new InvoiceResponse(invoice.getInvoiceId(), invoice.getPaymentId(), invoice.getInvoiceNumber(), invoice.getInvoiceDate());
    }

    public List<InvoiceResponse> getAllInvoices() {
        return invoiceRepository.findAll()
                .stream()
                .map(invoice -> new InvoiceResponse(invoice.getInvoiceId(), invoice.getPaymentId(), invoice.getInvoiceNumber(), invoice.getInvoiceDate()))
                .toList();
    }

}
