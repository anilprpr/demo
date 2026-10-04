package com.scale.demo.dto.cor;

import com.scale.demo.dto.PaymentHandler;
import com.scale.demo.dto.PaymentRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class CustomerValidationHandler implements PaymentHandler {

    @Override
    public void handle(PaymentRequest request) {

        // validation
        System.out.println("CustomerValidationHandler: Validating customer for request: " + request);
    }
}
