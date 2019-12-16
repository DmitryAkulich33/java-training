package by.epam.exercise13.controller;

import by.epam.exercise13.scanner.NumberReader;
import by.epam.exercise13.service.ArrayAction;

import java.util.Arrays;

public class ArrayCommand {
    public void exec() {
        NumberReader numberReader = new NumberReader();
        int number = numberReader.read();
        ArrayAction arrayAction = new ArrayAction();
        int[] array = arrayAction.getArray(number);
        System.out.println(Arrays.toString(array));

    }
}
