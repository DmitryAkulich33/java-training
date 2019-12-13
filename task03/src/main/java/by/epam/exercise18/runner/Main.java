package by.epam.exercise18.runner;

public class Main {
    public static void main(String[] args) {
        int length = 3;
        double e = 1;
        findTheNecessaryResult(length, e);
    }

    public static void findTheNecessaryResult(int length, double e) {
        double sum = 0;
        boolean flag = false;
        for (int i = 1; i < length; i++) {
            double number = Math.pow(-1, i - 1) / i;
            if (Math.abs(number) >= e) {
                sum = sum + number;
                flag = true;
            }
        }
        if (flag) {
            printCorrectData(sum);
        } else {
            printInCorrectData();
        }
    }

    public static void printCorrectData(double sum) {
        System.out.println("sum = " + sum);
    }

    public static void printInCorrectData() {
        System.out.println("There is no solution.");
    }
}
