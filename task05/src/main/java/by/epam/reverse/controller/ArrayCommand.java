package by.epam.reverse.controller;

import by.epam.reverse.service.ArrayAction;

import java.util.Arrays;

public class ArrayCommand {
    public void exec() {
        ArrayCreator arrayCreator = new ArrayCreator();
        int[] array = arrayCreator.createIntArray(10);
        System.out.println(Arrays.toString(array));
        ArrayAction arrayAction = new ArrayAction();
        int[] sortArray = arrayAction.reverse(array);
        System.out.println(Arrays.toString(sortArray));
    }
}
