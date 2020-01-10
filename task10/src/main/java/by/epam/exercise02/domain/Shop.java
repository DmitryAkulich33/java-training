package by.epam.exercise02.domain;

import java.util.HashMap;
import java.util.Map;

public class Shop {
    private String name;
    private Map<String, Integer> forSale = new HashMap<>();

    public Shop() {
    }

    public Shop(String name, Map<String, Integer> forSale) {
        this.name = name;
        this.forSale = forSale;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<String, Integer> getForSale() {
        return forSale;
    }

    public void setForSale(Map<String, Integer> forSale) {
        this.forSale = forSale;
    }

    @Override
    public String toString() {
        String line = "Shop is " + name + " :" + "\n";
        for(Map.Entry entry : forSale.entrySet()){
            line = line + entry.getKey() + " " + entry.getValue() + " BYN\n";

        }
        return line;
    }
}
