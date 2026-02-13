package state;

public interface OrderStateBehavior {

    boolean canCancel();
    boolean canRefund();

    OrderStatus confirm();
    OrderStatus ship();
    OrderStatus deliver();
    OrderStatus cancel();
}
