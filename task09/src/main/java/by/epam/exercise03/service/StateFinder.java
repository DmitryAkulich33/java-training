package by.epam.exercise03.service;

import by.epam.exercise03.domain.City;
import by.epam.exercise03.domain.State;

public class StateFinder {
    public int findStateSquare(State state) {
        int square = 0;
        for (City city : state.getCities()) {
            square = square + city.getSquare();
        }
        return square;
    }

    public int findCountOfRegions(State state) {
        return state.getRegions().size();
    }

}
