package by.epam.exercise03.controller;

import by.epam.exercise03.dao.LinesReader;
import by.epam.exercise03.dao.LinesWriter;
import by.epam.exercise03.domain.Constants;
import by.epam.exercise03.domain.State;
import by.epam.exercise03.service.StateCreator;
import by.epam.exercise03.service.StateFinder;
import by.epam.exercise03.view.Print;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        LinesReader linesReader = new LinesReader();
        StateCreator stateCreator = new StateCreator();
        List<String> lines = linesReader.returnListCitiesFromFile(Constants.PATH_CITIES_DATA);
        State state = stateCreator.returnState(lines, Constants.STATE_NAME, Constants.STATE_CAPITAL);
        StateFinder stateFinder = new StateFinder();
        Print print = new Print();
        print.printCountOfRegions(stateFinder.findCountOfRegions(state));
        print.printStateCapital(state);
        print.printStateRegions(state);
        print.printStateSquare(stateFinder.findStateSquare(state));
        LinesWriter linesWriter = new LinesWriter();
        linesWriter.writeListRegionsInFile(state, Constants.PATH_REGIONS_INFO);
        linesWriter.writeListDistrictsInFile(state, Constants.PATH_DISTRICTS_INFO);
        linesWriter.writeListCitiesInFile(state, Constants.PATH_CITY_INFO);
    }
}
