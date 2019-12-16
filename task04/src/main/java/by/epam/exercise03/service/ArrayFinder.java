package by.epam.exercise03.service;

public class ArrayFinder {
    public int gcd(int a, int b) {
        if (b == 0) {
            return Math.abs(a);
        }
        return gcd(b, a % b);
    }

    public int gcd(int[] array) {
        int result = gcd(array[0], array[1]);
        int length = array.length;
        for (int i = 2; i < length; i++) {
            result = gcd(result, array[i]);
        }
        return result;
    }
}
