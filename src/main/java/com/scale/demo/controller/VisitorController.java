package com.scale.demo.controller;

import com.scale.demo.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/visitor")
public class VisitorController {

    private final OrderService orderService;


    public VisitorController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/order/calculate")
    public void calculateTotal() {
         orderService.calculateOrder();
    }

}
