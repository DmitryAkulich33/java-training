package by.epam.bakery.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Basket extends Entity implements Serializable {
    private User user;
    private Pie pie;

    public Basket() {
    }

    public Basket(int id, User user, Pie pie) {
        super(id);
        this.user = user;
        this.pie = pie;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
        if (!(o instanceof Basket)) return false;
        if (!super.equals(o)) return false;

        Basket basket = (Basket) o;

        if (user != null ? !user.equals(basket.user) : basket.user != null) return false;
        return pie != null ? pie.equals(basket.pie) : basket.pie == null;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (pie != null ? pie.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Basket " +
                "user: " + user +
                ", pie: " + pie;
    }
}
