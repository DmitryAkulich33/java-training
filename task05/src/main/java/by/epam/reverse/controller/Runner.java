package by.epam.reverse.controller;

import by.epam.reverse.service.ArrayAction;
import by.epam.reverse.service.ArrayCreator;
import by.epam.reverse.view.ArrayViewer;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.createIntArray(10);
        ArrayViewer arrayViewer = new ArrayViewer();
        arrayViewer.printArray(array);
        ArrayAction arrayAction = new ArrayAction();
        int[] sortArray = arrayAction.reverse(array);
        arrayViewer.printArray(sortArray);
    }
}
