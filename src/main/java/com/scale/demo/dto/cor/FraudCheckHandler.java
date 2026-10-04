package com.scale.demo.dto.cor;

import com.scale.demo.dto.PaymentHandler;
import com.scale.demo.dto.PaymentRequest;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(3)
public class FraudCheckHandler implements PaymentHandler {

    @Override
    public void handle(PaymentRequest request) {

        // fraud check
        System.out.println("FraudCheckHandler: Performing fraud check for request: " + request);
    }


}
