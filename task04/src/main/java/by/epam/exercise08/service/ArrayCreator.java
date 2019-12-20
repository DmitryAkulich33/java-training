package by.epam.exercise08.service;

import by.epam.exercise08.service.exception.WrongDataException;

import java.util.Random;

public class ArrayCreator {
    private static final int MIN_VALUE = 10;
    private static final int MAX_VALUE = 40;

    public int[] createIntArray(int length) {
        if (length <= 0) {
            throw new WrongDataException("Invalid array length.");
        }
        Random random = new Random();
        int[] array = random.ints(length, MIN_VALUE, MAX_VALUE).toArray();
        return array;
    }
}
