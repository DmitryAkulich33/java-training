package by.epam.exercise08.runner;

public class Main {
    public static void main(String[] args) {
        int a = 6;
        int b = 7;
        print(findSmallerSquare(a, b));
    }

    public static int findSmallerSquare(int a, int b) {
        if (a * a > b * b) {
            return b * b;
        } else {
            return a * a;
        }
    }

    public static void print(int number) {
        System.out.println("Answer: " + number);
    }
}
