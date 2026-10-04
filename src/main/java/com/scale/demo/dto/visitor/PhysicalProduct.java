package com.scale.demo.dto.visitor;

public class PhysicalProduct implements OrderItem {

    private final String name;
    private final double price;
    private final double weight;

    public PhysicalProduct(
            String name,
            double price,
            double weight) {

        this.name = name;
        this.price = price;
        this.weight = weight;
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
    public double getWeight() {
        return weight;
    }


}
