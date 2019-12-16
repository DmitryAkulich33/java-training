package by.epam.exercise18.service;

import by.epam.exercise18.exception.WrongDataException;

import java.util.ArrayList;
import java.util.List;

public class ArrayAction {
    public boolean isIncreasing(int number) {
        int buffer;
        boolean isIncreasing = true;
        int length = getLengthOfArray(number);
        for (int i = length; i > 0; i--) {
            buffer = number / 10;
            if (number % 10 < (buffer % 10)) {
                isIncreasing = false;
            }
            if (number % 10 == buffer % 10) {  // если цифры не повторяются, то убрать этот if (11222)
                isIncreasing = false;
            }
            number = number / 10;
        }

        return isIncreasing;
    }

    public int getLengthOfArray(int number) {
        int length = 0;
        while (number != 0) {
            number = number / 10;
            length++;
        }
        return length;
    }

    public List<Integer> returnArray(int number, int digit) {
        if (digit > getLengthOfArray(number)) {
            throw new WrongDataException("The digit is wrong");
        }
        List<Integer> list = new ArrayList<>();
        int startNumber = (int) (Math.pow(10, digit - 1));
        int endNumber = (int) (Math.pow(10, digit));
        if (number > endNumber) {
            for (int i = startNumber; i < endNumber; i++) {
                if (isIncreasing(i)) {
                    list.add(i);
                }
            }
        } else {
            for (int i = startNumber; i <= number; i++) {
                if (isIncreasing(i)) {
                    list.add(i);
                }
            }
        }
        return list;
    }
}
