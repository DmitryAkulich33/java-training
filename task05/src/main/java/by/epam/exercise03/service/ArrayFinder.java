package by.epam.exercise03.service;

public class ArrayFinder {
    public String findElement(int[] array) {
        String message = "";
        int length = array.length;
        for (int i = 0; i < length; i++) {
            if (array[i] > 0) {
                message = "Posistive number is first.";
                break;
            } else if (array[i] < 0) {
                message = "Negative number is first.";
                break;
            }
        }
        return message;
    }
}
