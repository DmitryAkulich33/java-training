package by.epam.exercise03.service;

import by.epam.exercise03.domain.City;
import by.epam.exercise03.domain.District;
import by.epam.exercise03.domain.Region;
import by.epam.exercise03.domain.State;

public class StateFinder {
    public int findStateSquare(State state) {
        int square = 0;
        for(Region region : state.getRegions()){
            for (District district: region.getDistricts()){
                for(City city: district.getCity()){
                    square = square + city.getSquare();
                }
            }
        }
        return square;
    }

    public int findCountOfRegions(State state) {
        return state.getRegions().size();
    }

}
