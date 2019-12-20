package by.epam.shift.controller;

import by.epam.reverse.view.ArrayViewer;
import by.epam.shift.service.ArrayAction;
import by.epam.shift.service.ArrayCreator;

public class Runner {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.createIntArray(10);
        ArrayViewer arrayViewer = new ArrayViewer();
        arrayViewer.printArray(array);
        ArrayAction arrayFinder = new ArrayAction();
        arrayViewer.printArray(arrayFinder.shiftRight(array, 3));
        arrayViewer.printArray(arrayFinder.shiftLeft(array, 3));
    }
}
