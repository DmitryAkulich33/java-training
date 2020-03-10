package by.epam.bakery.domain;

import java.io.Serializable;

public class OrderProduct extends Entity implements Serializable {
    private Order order;
    private Pie pie;


    public OrderProduct() {
    }

    public OrderProduct(int id, Order order, Pie pie) {
        super(id);
        this.order = order;
        this.pie = pie;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Pie getPie() {
        return pie;
    }

    public void setPie(Pie pie) {
        this.pie = pie;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderProduct)) return false;
        if (!super.equals(o)) return false;

        OrderProduct that = (OrderProduct) o;

        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        return pie != null ? pie.equals(that.pie) : that.pie == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (pie != null ? pie.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderProduct order: " + order +
                ", pie: " + pie;
    }
}
