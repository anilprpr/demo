package com.scale.demo.dto.visitor;

import org.springframework.stereotype.Component;

@Component
public class TaxVisitor implements OrderVisitor {

    @Override
    public double visit(PhysicalProduct product) {
        return product.getPrice() * 0.18;
    }

    @Override
    public double visit(DigitalProduct product) {
        return product.getPrice() * 0.12;
    }

    @Override
    public double visit(ServiceProduct product) {
        return product.getPrice() * 0.18;
    }
}
