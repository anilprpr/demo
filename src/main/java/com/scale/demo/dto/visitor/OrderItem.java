package com.scale.demo.dto.visitor;

public interface OrderItem {
    double accept(OrderVisitor visitor);
}
