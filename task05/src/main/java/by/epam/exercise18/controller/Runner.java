package by.epam.exercise18.controller;

import by.epam.exercise18.service.ArrayAction;
import by.epam.exercise18.service.ArrayCreator;
import by.epam.exercise18.view.ArrayViewer;
import by.epam.exercise18.view.ReadNumber;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ReadNumber readNumber = new ReadNumber();
        List<Integer> list = readNumber.getValues();
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.getArray(list, 10);
        ArrayViewer arrayViewer = new ArrayViewer();
        arrayViewer.printArray(array);
        ArrayAction arrayAction = new ArrayAction();
        array = arrayAction.getArray(array, list.get(0), list.get(1));
        arrayViewer.printArray(array);
    }
}
