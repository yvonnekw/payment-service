package com.auction.payment_service.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long paymentId;
    private String fullNameOnPaymentCard;
    private String cardNumber;
    private String expiringDate;
    private String issueNumber;
    private String securityNumber;
    private Double amount;
    private Long userId;     // Reference to User (Buyer)
    private Long productId;  // Reference to Product
    private String paymentMethod;
    private LocalDateTime paymentDate;
    private boolean isSuccessful;
}