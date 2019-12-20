package by.epam.exercise18.controller;

import by.epam.exercise18.service.ArrayAction;
import by.epam.exercise18.view.NumberViewer;
import by.epam.exercise18.view.NumberReader;

public class Runner {
    public static void main(String[] args) {
        NumberReader numberReader = new NumberReader();
        int number = numberReader.read();
        ArrayAction arrayAction = new ArrayAction();
        NumberViewer arrayViewer = new NumberViewer();
        arrayViewer.printNumber(arrayAction.returnNumbers(number, 2));
    }
}
