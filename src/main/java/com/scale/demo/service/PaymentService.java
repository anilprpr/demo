package com.scale.demo.service;

import com.scale.demo.dto.PaymentHandler;
import com.scale.demo.dto.PaymentRequest;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PaymentService {

    private final List<PaymentHandler> handlers;

    public PaymentService(List<PaymentHandler> handlers) {
        this.handlers = handlers;
    }

    public void processPayment(PaymentRequest request) {

        for (PaymentHandler handler : handlers) {
            handler.handle(request);
        }
    }
}
