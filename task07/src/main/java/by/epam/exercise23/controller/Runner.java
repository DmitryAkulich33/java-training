package by.epam.exercise23.controller;

public class Runner {
    public static void main(String[] args) {
        int length = 6;
        double[][] array = new double[length][length];
        fillArray(array);
        printArray(array);
        printPositiveNumbersCount(findPositiveNumbersCount(array));
    }

    public static void fillArray(double[][] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = Math.sin(((i * i) - (j * j)) / length);
            }
        }
    }

    public static int findPositiveNumbersCount(double[][] array) {
        int length = array.length;
        int count = 0;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void printArray(double[][] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void printPositiveNumbersCount(int count) {
        System.out.println("Count of positive numbers: " + count);
    }
}
