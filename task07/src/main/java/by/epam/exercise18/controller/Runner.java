package by.epam.exercise18.controller;

public class Runner {
    public static void main(String[] args) {
        int length = 6;
        int[][] array = new int[length][length];
        fillArray(array);
        printArray(array);
    }

    public static void fillArray(int[][] array) {
        int length = array.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length - i; j++) {
                array[i][j] = i + 1;
            }
        }
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
