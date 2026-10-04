package com.scale.demo.dto.state;

import org.springframework.stereotype.Component;

@Component
public class CancelledState implements OrderState {

    @Override
    public void pay(OrderContext context) {

        throw new IllegalStateException(
                "Cancelled order cannot be paid"
        );
    }

    @Override
    public void ship(OrderContext context) {

        throw new IllegalStateException(
                "Cancelled order cannot be shipped"
        );
    }

    @Override
    public void deliver(OrderContext context) {

        throw new IllegalStateException(
                "Cancelled order cannot be delivered"
        );
    }
    @Override
    public void cancel(OrderContext context) {

        throw new IllegalStateException(
                "Order is already cancelled"
        );
    }

    @Override
    public String getStateName() {
        return "CANCELLED";
    }
}
