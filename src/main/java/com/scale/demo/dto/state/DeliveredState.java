package com.scale.demo.dto.state;

import org.springframework.stereotype.Component;

@Component
public class DeliveredState implements OrderState {

    @Override
    public void pay(OrderContext context) {

        throw new IllegalStateException(
                "Delivered order cannot be paid"
        );
    }

    @Override
    public void ship(OrderContext context) {

        throw new IllegalStateException(
                "Order is already delivered"
        );
    }

    @Override
    public void deliver(OrderContext context) {

        throw new IllegalStateException(
                "Order is already delivered"
        );
    }
    @Override
    public void cancel(OrderContext context) {

        throw new IllegalStateException(
                "Delivered order cannot be cancelled"
        );
    }

    @Override
    public String getStateName() {
        return "DELIVERED";
    }

}
