package by.epam.exercise03.domain;

import java.util.List;
import java.util.Set;

public class State {
    private String name;
    private String capital;
    private List<Region> regions;

    public State(String name, String capital, List<Region> regions) {
        this.name = name;
        this.capital = capital;
        this.regions = regions;
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

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }


    @Override
    public String toString() {
        String line = "State is " + name + ", capital is " + capital + " :\n" + "regions:";
        for(Region region : regions){
            line = line + "\n" + region;
        }
        return line;
    }
}
