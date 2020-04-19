package by.epam.bakery.domain;

import java.io.Serializable;

public class OrderProduct extends Entity implements Serializable {
    private Order order;
    private Pie pie;
    private int amount;
    private double cost;

    public OrderProduct() {
    }

    public OrderProduct(int id, Order order, Pie pie, int amount, double cost) {
        super(id);
        this.order = order;
        this.pie = pie;
        this.amount = amount;
        this.cost = cost;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
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

        if (amount != that.amount) return false;
        if (Double.compare(that.cost, cost) != 0) return false;
        if (order != null ? !order.equals(that.order) : that.order != null) return false;
        return pie != null ? pie.equals(that.pie) : that.pie == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (order != null ? order.hashCode() : 0);
        result = 31 * result + (pie != null ? pie.hashCode() : 0);
        result = 31 * result + amount;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "OrderProduct: " +
                "order: " + order +
                ", pie: " + pie +
                ", amount: " + amount +
                ", cost: " + cost;
    }
}
