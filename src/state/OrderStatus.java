package state;

import exception.InvalidOrderStateException;

public enum OrderStatus implements OrderStateBehavior {

    CREATED {
        public boolean canCancel() { return true; }
        public boolean canRefund() { return false; }

        public OrderStatus confirm() { return CONFIRMED; }

        public OrderStatus ship() {
            throw new InvalidOrderStateException("Cannot ship before confirmation.");
        }

        public OrderStatus deliver() {
            throw new InvalidOrderStateException("Cannot deliver before shipping.");
        }

        public OrderStatus cancel() { return CANCELLED; }
    },

    CONFIRMED {
        public boolean canCancel() { return true; }
        public boolean canRefund() { return false; }

        public OrderStatus confirm() {
            throw new InvalidOrderStateException("Already confirmed.");
        }

        public OrderStatus ship() { return SHIPPED; }

        public OrderStatus deliver() {
            throw new InvalidOrderStateException("Cannot deliver before shipping.");
        }

        public OrderStatus cancel() { return CANCELLED; }
    },

    SHIPPED {
        public boolean canCancel() { return false; }
        public boolean canRefund() { return false; }

        public OrderStatus confirm() {
            throw new InvalidOrderStateException("Already shipped.");
        }

        public OrderStatus ship() {
            throw new InvalidOrderStateException("Already shipped.");
        }

        public OrderStatus deliver() { return DELIVERED; }

        public OrderStatus cancel() {
            throw new InvalidOrderStateException("Cannot cancel after shipping.");
        }
    },

    DELIVERED {
        public boolean canCancel() { return false; }
        public boolean canRefund() { return true; }

        public OrderStatus confirm() {
            throw new InvalidOrderStateException("Order completed.");
        }

        public OrderStatus ship() {
            throw new InvalidOrderStateException("Order completed.");
        }

        public OrderStatus deliver() {
            throw new InvalidOrderStateException("Already delivered.");
        }

        public OrderStatus cancel() {
            throw new InvalidOrderStateException("Delivered order cannot be cancelled.");
        }
    },

    CANCELLED {
        public boolean canCancel() { return false; }
        public boolean canRefund() { return false; }

        public OrderStatus confirm() {
            throw new InvalidOrderStateException("Cancelled order locked.");
        }

        public OrderStatus ship() {
            throw new InvalidOrderStateException("Cancelled order locked.");
        }

        public OrderStatus deliver() {
            throw new InvalidOrderStateException("Cancelled order locked.");
        }

        public OrderStatus cancel() {
            throw new InvalidOrderStateException("Already cancelled.");
        }
    };
}
