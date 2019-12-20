package by.epam.exercise03.controller;

import by.epam.exercise03.service.ArrayCreator;
import by.epam.exercise03.service.ArrayFinder;
import by.epam.exercise03.view.ArrayViewer;

public class Runner {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        ArrayViewer arrayViewer = new ArrayViewer();
        int[] array = arrayCreator.createIntArray(10);
        arrayViewer.printArray(array);
        ArrayFinder arrayFinder = new ArrayFinder();
        arrayViewer.printResult(arrayFinder.findElement(array));
    }
}
