package by.epam.exercise13.controller;

import by.epam.exercise13.service.ArrayAction;
import by.epam.exercise13.view.ArrayViewer;
import by.epam.exercise13.view.NumberReader;


public class Runner {
    public static void main(String[] args) {
        NumberReader numberReader = new NumberReader();
        int number = numberReader.read();
        ArrayAction arrayAction = new ArrayAction();
        int[] array = arrayAction.getArray(number);
        ArrayViewer arrayViewer = new ArrayViewer();
        arrayViewer.printArray(array);
    }
}
