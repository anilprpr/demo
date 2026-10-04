package com.scale.demo.dto.visitor;

public interface OrderVisitor {

    double visit(PhysicalProduct product);

    double visit(DigitalProduct product);

    double visit(ServiceProduct product);
}
