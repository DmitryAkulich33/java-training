package by.epam.exercise08.controller;

import by.epam.exercise08.service.ArrayCreator;
import by.epam.exercise08.service.ArrayFinder;
import by.epam.exercise08.view.ArrayViewer;
import by.epam.exercise08.view.LengthReader;
import by.epam.exercise08.view.NumberViewer;


public class Runner {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        LengthReader readSize = new LengthReader();
        int[] array = arrayCreator.createIntArray(readSize.read());
        ArrayViewer arrayViewer = new ArrayViewer();
        NumberViewer numberViewer = new NumberViewer();
        arrayViewer.printArray(array);
        ArrayFinder arrayFinder = new ArrayFinder();
        int count = 2;
        numberViewer.printNumber(arrayFinder.findOtherMaxElem(array, count));
    }
}
