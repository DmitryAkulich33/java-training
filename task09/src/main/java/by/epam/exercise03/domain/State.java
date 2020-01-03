package by.epam.exercise03.domain;

import java.util.List;
import java.util.Set;

public class State {
    String name;
    String capital;
    Set<Region> regions;
    Set<District> districts;
    List<City> cities;

    public State(String name, String capital, Set<Region> regions, Set<District> districts, List<City> cities) {
        this.name = name;
        this.capital = capital;
        this.regions = regions;
        this.districts = districts;
        this.cities = cities;
    }

    public State() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public Set<Region> getRegions() {
        return regions;
    }

    public void setRegions(Set<Region> regions) {
        this.regions = regions;
    }

    public Set<District> getDistricts() {
        return districts;
    }

    public void setDistricts(Set<District> districts) {
        this.districts = districts;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    @Override
    public String toString() {
        return "State is " + name + ", capital is " + capital + " :\n" + regions + "\n" + districts + "\n" + cities;
    }
}
