package by.epam.exercise03.controller;

import by.epam.exercise03.service.ArrayCreator;
import by.epam.exercise03.service.ArrayFinder;
import by.epam.exercise03.view.ArrayViewer;
import by.epam.exercise03.view.LengthReader;


public class Runner {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        LengthReader readSize = new LengthReader();
        int[] array = arrayCreator.createIntArray(readSize.read());
        ArrayViewer arrayViewer = new ArrayViewer();
        arrayViewer.printArray(array);
        ArrayFinder arrayFinder = new ArrayFinder();
        arrayViewer.printResult(arrayFinder.gcd(array));
    }
}
