package com.scale.demo.service;

import com.scale.demo.dto.state.CreatedState;
import com.scale.demo.dto.state.OrderContext;
import com.scale.demo.dto.visitor.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final TaxVisitor taxVisitor;
    private final DiscountVisitor discountVisitor;
    private final TotalVisitor totalVisitor;

    private final OrderContext orderContext;
    private final CreatedState createdState;


    public void calculateOrder() {

        List<OrderItem> items = List.of(
                new PhysicalProduct("Laptop", 50000, 2.5),
                new DigitalProduct("Ebook", 1000),
                new ServiceProduct("Installation", 2000)
        );
        double total = items.stream()
                .mapToDouble(item -> item.accept(totalVisitor))
                .sum();

        double tax = items.stream()
                .mapToDouble(item -> item.accept(taxVisitor))
                .sum();

        double discount = items.stream()
                .mapToDouble(item -> item.accept(discountVisitor))
                .sum();

        System.out.println("Grand Total = " + total);
        System.out.println("Tax = " + tax);
        System.out.println("Discount = " + discount);
        System.out.println("--------------------------------------------");
        double netPayable = (total + tax - discount);
        System.out.println("Net Payable = " + netPayable);
    }

    public void createOrder() {

        calculateOrder();
        // Set initial state
        orderContext.setState(createdState);

        System.out.println("Order created");
    }

    public void pay() {
        orderContext.pay();
    }

    public void ship() {
        orderContext.ship();
    }

    public void deliver() {
        orderContext.deliver();
    }

    public void cancel() {
        orderContext.cancel();
    }

    public String getCurrentState() {

        return orderContext
                .getCurrentState()
                .getStateName();
    }
}
