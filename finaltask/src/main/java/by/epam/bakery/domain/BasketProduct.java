package by.epam.bakery.domain;

import java.io.Serializable;

public class BasketProduct extends Entity implements Serializable {
    private Basket basket;
    private Pie pie;
    private int amount;
    private double cost;

    public BasketProduct() {
    }

    public BasketProduct(int id, Basket basket, Pie pie, int amount, double cost) {
        super(id);
        this.basket = basket;
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

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
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
        if (!(o instanceof BasketProduct)) return false;
        if (!super.equals(o)) return false;

        BasketProduct that = (BasketProduct) o;

        if (amount != that.amount) return false;
        if (Double.compare(that.cost, cost) != 0) return false;
        if (basket != null ? !basket.equals(that.basket) : that.basket != null) return false;
        return pie != null ? pie.equals(that.pie) : that.pie == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        result = 31 * result + (basket != null ? basket.hashCode() : 0);
        result = 31 * result + (pie != null ? pie.hashCode() : 0);
        result = 31 * result + amount;
        temp = Double.doubleToLongBits(cost);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "BasketProduct " +
                "basket: " + basket +
                ", pie: " + pie +
                ", amount: " + amount +
                ", cost: " + cost;
    }
}
