package model;

import state.OrderStatus;

public class Order {

    private final String orderId;
    private final String customerName;
    private OrderStatus status;

    public Order(String orderId, String customerName) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.status = OrderStatus.CREATED;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public OrderStatus getStatus() {
        return status;
    }

    // Controlled state changes
    public void confirm() {
        status = status.confirm();
    }

    public void ship() {
        status = status.ship();
    }

    public void deliver() {
        status = status.deliver();
    }

    public void cancel() {
        status = status.cancel();
    }

    public boolean canCancel() {
        return status.canCancel();
    }

    public boolean canRefund() {
        return status.canRefund();
    }
}
