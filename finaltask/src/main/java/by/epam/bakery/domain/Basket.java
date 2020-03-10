package by.epam.bakery.domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public List<Pie> pies = new ArrayList<>();

    public Basket() {
    }

    public Basket(List<Pie> pies) {
        this.pies = pies;
    }

    public List<Pie> getPies() {
        return pies;
    }

    public void setPies(List<Pie> pies) {
        this.pies = pies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Basket)) return false;

        Basket basket = (Basket) o;

        return pies != null ? pies.equals(basket.pies) : basket.pies == null;
    }

    @Override
    public int hashCode() {
        return pies != null ? pies.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Basket pies: " + pies;
    }
}
