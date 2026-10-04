package com.scale.demo.dto.visitor;

import org.springframework.stereotype.Component;

@Component
public class TotalVisitor implements OrderVisitor{

    private double total;

    public TotalVisitor() {
        this.total = 0;
    }

    @Override
    public double visit(PhysicalProduct product) {
        total += product.getPrice();
        return total;
    }

    @Override
    public double visit(DigitalProduct product) {
        total += product.getPrice();
        return total;
    }

    @Override
    public double visit(ServiceProduct product) {
        total += product.getPrice();
        return total;
    }

    public double getTotal() {
        return total;
    }
}
