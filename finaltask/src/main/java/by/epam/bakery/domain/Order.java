package by.epam.bakery.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order extends Entity implements Serializable {
    private User user;
    private LocalDateTime productionDate;
    private LocalDateTime deliveryDate;
    private StatusEnum status;

    public Order() {
    }

    public Order(int id, User user, LocalDateTime productionDate, LocalDateTime deliveryDate, StatusEnum status) {
        super(id);
        this.user = user;
        this.productionDate = productionDate;
        this.deliveryDate = deliveryDate;
        this.status = status;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getProductionDate() {
        return productionDate;
    }

    public void setProductionDate(LocalDateTime productionDate) {
        this.productionDate = productionDate;
    }

    public LocalDateTime getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDateTime deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        if (!super.equals(o)) return false;

        Order order = (Order) o;

        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (productionDate != null ? !productionDate.equals(order.productionDate) : order.productionDate != null)
            return false;
        if (deliveryDate != null ? !deliveryDate.equals(order.deliveryDate) : order.deliveryDate != null) return false;
        return status == order.status;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (productionDate != null ? productionDate.hashCode() : 0);
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Order user: " + user +
                ", productionDate: " + productionDate +
                ", deliveryDate: " + deliveryDate +
                ", status: " + status;
    }
}
