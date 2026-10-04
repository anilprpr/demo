package com.scale.demo.dto.cor;

import com.scale.demo.dto.PaymentHandler;
import com.scale.demo.dto.PaymentRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class AmountValidationHandler implements PaymentHandler {

    @Override
    public void handle(PaymentRequest request) {

        // validation
        System.out.println("AmountValidationHandler: Validating amount for request: " + request);
    }
}
