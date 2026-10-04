package com.scale.demo.dto.cor;

import com.scale.demo.dto.PaymentHandler;
import com.scale.demo.dto.PaymentRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(4)
public class PaymentProcessingHandler implements PaymentHandler {

    @Override
    public void handle(PaymentRequest request) {

        // processing payment
        System.out.println("PaymentProcessingHandler: Processing payment for request: " + request);

    }
}
