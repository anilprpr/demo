package com.scale.demo.dto.state;

import org.springframework.stereotype.Component;

@Component
public class OrderContext {

    private OrderState currentState;

    public void setState(OrderState state) {
        this.currentState = state;

        System.out.println(
                "Order state changed to: "
                        + state.getStateName()
        );
    }

    public OrderState getCurrentState() {
        return currentState;
    }

    public void pay() {
        currentState.pay(this);
    }

    public void ship() {
        currentState.ship(this);
    }

    public void deliver() {
        currentState.deliver(this);
    }
    public void cancel() {
        currentState.cancel(this);
    }
}
