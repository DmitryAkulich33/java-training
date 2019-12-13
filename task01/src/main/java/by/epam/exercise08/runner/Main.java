package by.epam.exercise08.runner;

public class Main {
    public static void main(String[] args) {
        calculateValue(1, 2, 3);
        calculateValue(0, 2, 3);
    }

    public static void calculateValue(double a, double b, double c) {
        if (a != 0) {
            double result = ((b + Math.sqrt(b * b + 4 * a * c)) / (2 * a)) - Math.pow(a, 3) * c + Math.pow(b, -2);
            printCorrectData(result);
        } else {
            printInCorrectData();
        }
    }

    public static void printCorrectData(double result) {
        System.out.println("Answer: " + result);
    }

    public static void printInCorrectData() {
        System.out.println("Cannot be divided by zero.");
    }


}
