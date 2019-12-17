package by.epam.exercise08.controller;

import by.epam.exercise08.service.ArrayFinder;

import java.util.Arrays;

public class ArrayCommand {
    public void exec() {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.createIntArray(10);
        System.out.println(Arrays.toString(array));
        ArrayFinder arrayFinder = new ArrayFinder();
        System.out.println("Count of positive elements are " + arrayFinder.returnPositiveElement(array));
        System.out.println("Count of negative elements are " + arrayFinder.returnNegativeElement(array));
        System.out.println("Count of zero elements are " + arrayFinder.returnZeroElement(array));
    }
}
