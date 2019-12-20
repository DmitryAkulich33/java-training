package by.epam.exercise08.controller;

import by.epam.exercise08.service.ArrayCreator;
import by.epam.exercise08.service.ArrayFinder;
import by.epam.exercise08.view.NumberViewer;

import java.util.Arrays;

public class Runner {
    public static void main(String[] args) {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.createIntArray(10);
        System.out.println(Arrays.toString(array));
        ArrayFinder arrayFinder = new ArrayFinder();
        NumberViewer numberViewer = new NumberViewer();
        numberViewer.printPositiveCount(arrayFinder.returnPositiveElement(array));
        numberViewer.printNegativeCount(arrayFinder.returnNegativeElement(array));
        numberViewer.printZeroCount(arrayFinder.returnZeroElement(array));
    }
}
