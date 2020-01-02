package by.epam.exercise08.controller;

import java.util.Random;

public class Runner {
    public static void main(String[] args) {
        int length = 6;
        int minValue = 0;
        int maxValue = 10;
        int number = 7;
        int[][] array = createTwoDimensionalArray(length, minValue, maxValue);
        printArray(array);
        printNumberCount(number, findNumberCount(array, number));
    }

    public static int[][] createTwoDimensionalArray(int length, int minValue, int maxValue) {
        Random random = new Random();
        int[][] array = new int[length][length];
        for (int i = 0; i < length; i++) {
            array[i] = random.ints(length, minValue, maxValue).toArray();
        }
        return array;
    }

    public static int findNumberCount(int[][] array, int number) {
        int length = array.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (array[i][j] == number) {
                    count++;
                }
            }
        }
        return count;
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

    public static void printNumberCount(int number, int count) {
        System.out.println("Number " + number + " in array: " + count);
    }
}

