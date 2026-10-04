package com.scale.demo.dto.state;

import org.springframework.stereotype.Component;

@Component
public class PaidState implements OrderState {

    private final ShippedState shippedState;
    private final CancelledState cancelledState;

    public PaidState(
            ShippedState shippedState,
            CancelledState cancelledState) {

        this.shippedState = shippedState;
        this.cancelledState = cancelledState;
    }

    @Override
    public void pay(OrderContext context) {

        throw new IllegalStateException(
                "Order is already paid"
        );
    }

    @Override
    public void ship(OrderContext context) {

        System.out.println("Order shipped");

        context.setState(shippedState);
    }

    @Override
    public void deliver(OrderContext context) {

        throw new IllegalStateException(
                "Order must be shipped first"
        );
    }

    @Override
    public void cancel(OrderContext context) {

        System.out.println("Payment refunded");

        context.setState(cancelledState);
    }

    @Override
    public String getStateName() {
        return "PAID";
    }


}
