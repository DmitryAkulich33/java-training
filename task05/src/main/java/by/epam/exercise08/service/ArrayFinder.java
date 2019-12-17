package by.epam.exercise08.service;

public class ArrayFinder {
    public int returnPositiveElement(int[] array) {
        int length = array.length;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] > 0) {
                counter++;
            }
        }
        return counter;
    }

    public int returnNegativeElement(int[] array) {
        int length = array.length;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] < 0) {
                counter++;
            }
        }
        return counter;
    }

    public int returnZeroElement(int[] array) {
        int length = array.length;
        int counter = 0;
        for (int i = 0; i < length; i++) {
            if (array[i] == 0) {
                counter++;
            }
        }
        return counter;
    }

}
