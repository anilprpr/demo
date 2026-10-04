package com.scale.demo.dto;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class PaymentRequest {

    private String customerId;
    private String accountNumber;
    private BigDecimal amount;
}
