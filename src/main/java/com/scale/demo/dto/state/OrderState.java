package com.scale.demo.dto.state;

public interface OrderState {

    void pay(OrderContext context);

    void ship(OrderContext context);

    void deliver(OrderContext context);

    void cancel(OrderContext context);

    String getStateName();
}
