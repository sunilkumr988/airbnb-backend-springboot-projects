package com.Sunil.Projects.AirBnbApp.entities;

import com.Sunil.Projects.AirBnbApp.entities.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true,nullable = false)
    private String transactionId;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private PaymentStatus paymentStatus;
    @Column(nullable = false,precision = 10,scale = 2)
    private Integer amount;

}
