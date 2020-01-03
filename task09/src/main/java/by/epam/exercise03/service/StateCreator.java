package by.epam.exercise03.service;

import by.epam.exercise03.domain.*;
import by.epam.exercise03.service.exception.EmptyListException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StateCreator {
    public State returnState(List<String> lines, String name, String capital) {
        return new State(name, capital, returnRegionList(lines), returnDistrictList(lines), returnCityList(lines));
    }

    public List<City> returnCityList(List<String> lines) {
        if (lines.isEmpty()) {
            throw new EmptyListException("List of cities is empty");
        }
        List<City> cities = new ArrayList<>();
        for (String line : lines) {
            String[] valuesFromLine = line.split(",\\s");
            String name = valuesFromLine[2];
            int square = Integer.parseInt(valuesFromLine[3]);
            cities.add(new City(name, square));
        }
        return cities;
    }

    public Set<District> returnDistrictList(List<String> lines) {
        if (lines.isEmpty()) {
            throw new EmptyListException("List of cities is empty");
        }
        Set<District> districts = new HashSet<>();
        for (String line : lines) {
            String[] valuesFromLine = line.split(",\\s");
            String name = valuesFromLine[1];
            districts.add(new District(name));
        }
        return districts;
    }

    public Set<Region> returnRegionList(List<String> lines) {
        if (lines.isEmpty()) {
            throw new EmptyListException("List of cities is empty");
        }
        Set<Region> regions = new HashSet<>();
        for (String line : lines) {
            String[] valuesFromLine = line.split(",\\s");
            String name = valuesFromLine[0];
            String regionalCity = returnRegionalCity(valuesFromLine[0]);
            regions.add(new Region(name, regionalCity));
        }
        return regions;
    }

    public String returnRegionalCity(String name) {
        String regionalCity = "";
        switch (name) {
            case "Brestskaya":
                regionalCity = "Brest";
                break;
            case "Mogilevskaya":
                regionalCity = "Mogilev";
                break;
            case "Minskaya":
                regionalCity = "Minsk";
                break;
        }
        return regionalCity;
    }
}
