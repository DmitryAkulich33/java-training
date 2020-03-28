package by.epam.bakery.domain;

import java.io.Serializable;

public class BasketProduct extends Entity implements Serializable {
    private Basket basket;
    private Pie pie;

    public BasketProduct() {
    }

    public BasketProduct(int id, Basket basket, Pie pie) {
        super(id);
        this.basket = basket;
        this.pie = pie;
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

        if (basket != null ? !basket.equals(that.basket) : that.basket != null) return false;
        return pie != null ? pie.equals(that.pie) : that.pie == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (basket != null ? basket.hashCode() : 0);
        result = 31 * result + (pie != null ? pie.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "BasketProduct " +
                "basket: " + basket +
                ", pie: " + pie;
    }
}
