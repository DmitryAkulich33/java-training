package by.epam.exercise03.controller;

import by.epam.exercise03.scanner.LengthReader;
import by.epam.exercise03.service.ArrayFinder;

import java.util.Arrays;

public class ArrayCommand {
    public void exec() {
        ArrayCreator arrayCreator = new ArrayCreator();
        LengthReader readSize = new LengthReader();
        int[] array = arrayCreator.createIntArray(readSize.read());
        System.out.println(Arrays.toString(array));
        ArrayFinder arrayFinder = new ArrayFinder();
        System.out.println(arrayFinder.gcd(array));
    }
}
