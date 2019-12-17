package by.epam.shift.controller;

import by.epam.shift.service.ArrayAction;

import java.util.Arrays;

public class ArrayCommand {
    public void exec() {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.createIntArray(10);
        System.out.println(Arrays.toString(array));
        ArrayAction arrayFinder = new ArrayAction();
        System.out.println(Arrays.toString(arrayFinder.shiftRight(array, 3)));
        System.out.println(Arrays.toString(arrayFinder.shiftLeft(array, 3)));
    }
}
