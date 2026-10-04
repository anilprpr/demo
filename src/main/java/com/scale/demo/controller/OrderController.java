package com.scale.demo.controller;

import com.scale.demo.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/calculate")
    public void calculateTotal() {
        orderService.calculateOrder();
    }

    @PostMapping("/create")
    public String createOrder() {

        orderService.createOrder();

        return "Order created";
    }

    @PostMapping("/pay")
    public String pay() {

        orderService.pay();

        return "Payment successful";
    }

    @PostMapping("/ship")
    public String ship() {

        orderService.ship();

        return "Order shipped";
    }

    @PostMapping("/deliver")
    public String deliver() {

        orderService.deliver();

        return "Order delivered";
    }

    @PostMapping("/cancel")
    public String cancel() {

        orderService.cancel();

        return "Order cancelled";
    }

    @GetMapping("/state")
    public String state() {

        return orderService.getCurrentState();
    }
}
