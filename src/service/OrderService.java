package service;

import model.Order;

public class OrderService {

    public void confirmOrder(Order order) {
        order.confirm();
        System.out.println("Order confirmed.");
    }

    public void shipOrder(Order order) {
        order.ship();
        System.out.println("Order shipped.");
    }

    public void deliverOrder(Order order) {
        order.deliver();
        System.out.println("Order delivered.");
    }

    public void cancelOrder(Order order) {
        order.cancel();
        System.out.println("Order cancelled.");
    }
}
