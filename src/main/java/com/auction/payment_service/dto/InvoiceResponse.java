package com.auction.payment_service.dto;


import lombok.*;

import java.time.LocalDateTime;


@Builder
public record InvoiceResponse(Long invoiceId, Long paymentId, String invoiceNumber, LocalDateTime invoiceDate) {

}
