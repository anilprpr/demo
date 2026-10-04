package com.scale.demo.controller;

import com.scale.demo.dto.PaymentRequest;
import com.scale.demo.service.PaymentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @PostMapping
    public ResponseEntity<String> pay(
            @RequestBody PaymentRequest request) {

        paymentService.processPayment(request);

        return ResponseEntity.ok(
                "Payment processed successfully");
    }
}
