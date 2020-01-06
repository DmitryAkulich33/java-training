package by.epam.exercise03.controller;

import by.epam.exercise03.dao.LinesReader;
import by.epam.exercise03.dao.LinesWriter;
import by.epam.exercise03.dao.exception.StreamNotReadingException;
import by.epam.exercise03.dao.exception.StreamNotWritingException;
import by.epam.exercise03.domain.Constants;
import by.epam.exercise03.domain.State;
import by.epam.exercise03.service.StateCreator;
import by.epam.exercise03.service.StateFinder;
import by.epam.exercise03.service.exception.EmptyListException;
import by.epam.exercise03.view.Viewer;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        LinesReader linesReader = new LinesReader();
        StateCreator stateCreator = new StateCreator();
        LinesWriter linesWriter = new LinesWriter();
        StateFinder stateFinder = new StateFinder();
        Viewer viewer = new Viewer();
        State state = null;

        try {
            List<String> lines = linesReader.returnListCitiesFromFile(Constants.PATH_CITIES_DATA);
            state = stateCreator.returnState(Constants.STATE_NAME, Constants.STATE_CAPITAL, lines);
            linesWriter.writeStateInformationInFile(state, Constants.PATH_STATE_INFO);
        } catch (StreamNotReadingException | StreamNotWritingException | EmptyListException e) {
            System.out.println(e.getMessage());
            e.printStackTrace();
        }

        viewer.printCountOfRegions(stateFinder.findCountOfRegions(state));
        viewer.printStateCapital(state);
        viewer.printStateRegions(state);
        viewer.printStateSquare(stateFinder.findStateSquare(state));
    }
}
