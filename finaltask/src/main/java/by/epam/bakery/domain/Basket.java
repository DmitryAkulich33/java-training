package by.epam.bakery.domain;

import java.util.ArrayList;
import java.util.List;

public class Basket {
    public List<Pie> pies = new ArrayList<>();

    public Basket() {
    }

    public List<Pie> getPies() {
        return pies;
    }

    public void setPies(List<Pie> pies) {
        this.pies = pies;
    }
}
