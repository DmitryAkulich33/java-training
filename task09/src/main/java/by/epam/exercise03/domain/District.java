package by.epam.exercise03.domain;

import java.util.List;

public class District {
    private String name;
    private List<City> city;

    public District(String name, List<City> city) {
        this.name = name;
        this.city = city;
    }

    public District() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<City> getCity() {
        return city;
    }

    public void setCity(List<City> city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return name + " r-n, " + " cities: " + city;
    }
}
