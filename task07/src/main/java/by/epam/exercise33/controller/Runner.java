package by.epam.exercise33.controller;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        int length = 6;
        int minValue = 0;
        int maxValue = 10;
        int[][] array = createTwoDimensionalArray(length, minValue, maxValue);
        printArray(array);
        printArray(increaseSort(array));
        printArray(decreaseSort(array));
    }

    public static int[][] createTwoDimensionalArray(int length, int minValue, int maxValue) {
        Random random = new Random();
        int[][] array = new int[length][length];
        for (int i = 0; i < length; i++) {
            array[i] = random.ints(length, minValue, maxValue).toArray();
        }
        return array;
    }

    public static int[][] increaseSort(int[][] array) {
        int length = array.length;
        for (int j = 0; j < length; j++) {
            for (int i = length - 1; i >= 1; i--) {
                for (int k = 0; k < i; k++) {
                    if (array[k][j] > array[k + 1][j]) {
                        swap(array, k, j);
                    }
                }
            }
        }
        return array;
    }

    public static int[][] decreaseSort(int[][] array) {
        int length = array.length;
        for (int j = 0; j < length; j++) {
            for (int i = length - 1; i >= 1; i--) {
                for (int k = 0; k < i; k++) {
                    if (array[k][j] < array[k + 1][j]) {
                        swap(array, k, j);
                    }
                }
            }
        }
        return array;
    }

    public static void swap(int[][] array, int k, int j) {
        int temp = array[k][j];
        array[k][j] = array[k + 1][j];
        array[k + 1][j] = temp;
    }

    public static void printArray(int[][] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
