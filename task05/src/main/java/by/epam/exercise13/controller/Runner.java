package by.epam.exercise13.controller;

import by.epam.exercise13.service.NumberAction;
import by.epam.exercise13.view.NumberViewer;

public class Runner {
    public static void main(String[] args) {
        NumberAction numberAction = new NumberAction();
        int counter = numberAction.getCount(2, 8, 2);
        NumberViewer numberViewer = new NumberViewer();
        numberViewer.printResult(counter);
    }
}
