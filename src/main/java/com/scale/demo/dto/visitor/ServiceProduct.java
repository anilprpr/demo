package com.scale.demo.dto.visitor;

public class ServiceProduct implements OrderItem {

    private final String name;
    private final double price;

    public ServiceProduct(String name, double price) {
        this.name = name;
        this.price = price;
    }

    @Override
    public double accept(OrderVisitor visitor) {
        return visitor.visit(this);
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
