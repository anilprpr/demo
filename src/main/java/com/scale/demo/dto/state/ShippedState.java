package com.scale.demo.dto.state;

import org.springframework.stereotype.Component;

@Component
public class ShippedState implements OrderState {

    private final DeliveredState deliveredState;

    public ShippedState(DeliveredState deliveredState) {
        this.deliveredState = deliveredState;
    }

    @Override
    public void pay(OrderContext context) {

        throw new IllegalStateException(
                "Order is already paid"
        );
    }

    @Override
    public void ship(OrderContext context) {

        throw new IllegalStateException(
                "Order is already shipped"
        );
    }

    @Override
    public void deliver(OrderContext context) {

        System.out.println("Order delivered");
        context.setState(deliveredState);
    }

    @Override
    public void cancel(OrderContext context) {

        throw new IllegalStateException(
                "Shipped order cannot be cancelled"
        );
    }

    @Override
    public String getStateName() {
        return "SHIPPED";
    }


    }
