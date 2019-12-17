package by.epam.exercise03.controller;

import by.epam.exercise03.service.ArrayFinder;

import java.util.Arrays;

public class ArrayCommand {
    public void exec() {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.createIntArray(10);
        System.out.println(Arrays.toString(array));
        ArrayFinder arrayFinder = new ArrayFinder();
        System.out.println(arrayFinder.returnElement(array));
    }
}
