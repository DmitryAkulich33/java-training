package by.epam.exercise13.service;

public class ArrayAction {
    public int getLengthOfArray(int number) {
        int length = 0;
        while (number != 0) {
            number = number / 10;
            length++;
        }
        return length;
    }

    public int[] getArray(int number) {
        int length = getLengthOfArray(number);
        int array[] = new int[length];
        number = Math.abs(number);
        for (int i = length - 1; i >= 0; i--) {
            array[i] = number % 10;
            number = number / 10;
        }
        return array;
    }

}
