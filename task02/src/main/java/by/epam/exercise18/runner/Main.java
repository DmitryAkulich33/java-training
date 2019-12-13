package by.epam.exercise18.runner;

public class Main {
    public static void main(String[] args) {
        int a = -1;
        int b = 2;
        int c = -2;
        print(findCountOfNegativeNumbers(a, b, c));
    }

    public static int findCountOfNegativeNumbers(int a, int b, int c) {
        int count = 0;
        if (a < 0) {
            count++;
        }
        if (b < 0) {
            count++;
        }
        if (c < 0) {
            count++;
        }
        return count;
    }

    public static void print(int count) {
        System.out.println("Number of negative numbers: " + count);
    }
}
