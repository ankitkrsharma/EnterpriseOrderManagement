package app;

import model.Order;
import exception.InvalidOrderStateException;
import service.OrderService;

public class App {

    public static void main(String[] args) {

        OrderService service = new OrderService();
        Order order = new Order("ORD-101", "Ankit");

        try {
            service.confirmOrder(order);
            service.shipOrder(order);
            service.deliverOrder(order);

            System.out.println("Can Refund? " + order.canRefund());

        } 
        catch (InvalidOrderStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
