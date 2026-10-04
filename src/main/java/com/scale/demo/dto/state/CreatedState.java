package com.scale.demo.dto.state;

import org.springframework.stereotype.Component;

@Component
public class CreatedState implements OrderState{

    private final PaidState paidState;
    private final CancelledState cancelledState;

    public CreatedState(
            PaidState paidState,
            CancelledState cancelledState) {

        this.paidState = paidState;
        this.cancelledState = cancelledState;
    }

    @Override
    public void pay(OrderContext context) {

        System.out.println("Payment successful");

        context.setState(paidState);
    }

    @Override
    public void ship(OrderContext context) {

        throw new IllegalStateException(
                "Order cannot be shipped before payment"
        );
    }
    @Override
    public void deliver(OrderContext context) {

        throw new IllegalStateException(
                "Order cannot be delivered before shipping"
        );
    }

    @Override
    public void cancel(OrderContext context) {

        System.out.println("Order cancelled");

        context.setState(cancelledState);
    }

    @Override
    public String getStateName() {
        return "CREATED";
    }
}
