package by.epam.exercise08.controller;

import by.epam.exercise08.scanner.LengthReader;
import by.epam.exercise08.service.ArrayFinder;

import java.util.Arrays;

public class ArrayCommand {
    public void exec() {
        ArrayCreator arrayCreator = new ArrayCreator();
        LengthReader readSize = new LengthReader();
        int[] array = arrayCreator.createIntArray(readSize.read());
        System.out.println(Arrays.toString(array));
        ArrayFinder arrayFinder = new ArrayFinder();
        int count = 2;
        System.out.println(arrayFinder.findOtherMaxElem(array, count));

    }
}
