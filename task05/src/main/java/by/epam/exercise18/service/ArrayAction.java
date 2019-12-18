package by.epam.exercise18.service;

import by.epam.exercise18.exception.WrongDataException;
import by.epam.exercise18.validator.ArrayValidator;

public class ArrayAction {
    public int[] getArray(int[] array, int index1, int index2) {
        if (index1 > index2) {
            int temp = index1;
            index1 = index2;
            index2 = temp;
        }
        fillRightSide(array, index1);
        fillLeftSide(array, index1);
        if (index2 - index1 != 3) {
            fillRightSide(array, index2);
            fillLeftSide(array, index2);
            fillNullElement(array);
        } else {
            fillSecondValue(array, index1);
            fillRightSide(array, index1 + 1);
            fillLeftSide(array, index1 + 1);
            fillNullElement(array);
        }
        return array;
    }

    public void fillRightSide(int[] array, int index) {
        int length = array.length;
        int rightIndex = index + 3;
        while (rightIndex < length) {
            array[rightIndex] = array[index];
            rightIndex = rightIndex + 3;
        }
    }

    public void fillLeftSide(int[] array, int index) {
        int leftIndex = index - 3;
        while (leftIndex >= 0) {
            array[leftIndex] = array[index];
            leftIndex = leftIndex - 3;
        }
    }

    public int getThirdNumber(int a, int b) {
        return 10 - a - b;
    }

    public int getSecondNumber(int a, int b) {
        return (10 - a - b) / 2;
    }

    public void fillSecondValue(int[] array, int index) {
        array[index + 1] = getSecondNumber(array[index], 0);
    }

    public void fillNullElement(int[] array) {
        int length = array.length;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 0) {
                if (i + 2 <= length - 1) {
                    array[i] = getThirdNumber(array[i + 1], array[i + 2]);
                }
            }
        }
    }
}
