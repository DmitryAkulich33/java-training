package by.epam.bakery.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Order extends Entity implements Serializable {
    private User user;
    private double total;
    private LocalDateTime productionDate;
    private LocalDateTime deliveryDate;
    private StatusEnum status;

    public Order() {
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
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

        if (Double.compare(order.total, total) != 0) return false;
        if (user != null ? !user.equals(order.user) : order.user != null) return false;
        if (productionDate != null ? !productionDate.equals(order.productionDate) : order.productionDate != null)
            return false;
        if (deliveryDate != null ? !deliveryDate.equals(order.deliveryDate) : order.deliveryDate != null) return false;
        return status == order.status;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (user != null ? user.hashCode() : 0);
        temp = Double.doubleToLongBits(total);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (productionDate != null ? productionDate.hashCode() : 0);
        result = 31 * result + (deliveryDate != null ? deliveryDate.hashCode() : 0);
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "Order user: " + user +
                ", total: " + total +
                ", productionDate: " + productionDate +
                ", deliveryDate: " + deliveryDate +
                ", status: " + status;
    }
}
