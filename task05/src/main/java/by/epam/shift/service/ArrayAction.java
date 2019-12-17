package by.epam.shift.service;

public class ArrayAction {
    public int[] shiftRight(int[] array, int positions) {
        int length = array.length;
        for (int i = 0; i < positions; i++) {
            int temp = array[length - 1];
            for (int j = length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = temp;
        }
        return array;
    }

    public int[] shiftLeft(int[] array, int positions) {
        int length = array.length;
        for (int i = length; i > positions; i--) {
            int temp = array[length - 1];
            for (int j = length - 1; j > 0; j--) {
                array[j] = array[j - 1];
            }
            array[0] = temp;
        }
        return array;
    }
}
