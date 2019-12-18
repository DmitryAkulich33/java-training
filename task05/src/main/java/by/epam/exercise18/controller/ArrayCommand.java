package by.epam.exercise18.controller;

import by.epam.exercise18.scanner.ReadNumber;
import by.epam.exercise18.service.ArrayAction;

import java.util.Arrays;
import java.util.List;

public class ArrayCommand {
    public void exec() {
        ReadNumber readNumber = new ReadNumber();
        List<Integer> list = readNumber.getValues();
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.getArray(list, 10);
        System.out.println(Arrays.toString(array));
        ArrayAction arrayAction = new ArrayAction();
        array = arrayAction.getArray(array, list.get(0), list.get(1));
        System.out.println(Arrays.toString(array));
    }
}
