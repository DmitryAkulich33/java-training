package by.epam.exercise03.view;

import java.util.Arrays;

public class ArrayViewer {
    public void printArray(int[] array) {
        System.out.println(Arrays.toString(array));
    }

    public void printResult(int number) {
        System.out.println("GCD is " + number);
    }
}
