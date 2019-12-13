package by.epam.exercise08.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        double a;
        double b;
        double c;
        double result;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a:");
        a = scanner.nextDouble();
        System.out.println("Enter b:");
        b = scanner.nextDouble();
        System.out.println("Enter c:");
        c = scanner.nextDouble();
        scanner.close();
        if (a != 0) {
            result = ((b + Math.sqrt(b * b + 4 * a * c)) / (2 * a)) - Math.pow(a, 3) * c + Math.pow(b, -2);
            System.out.println("Answer: " + result);
        } else {
            System.out.println("Cannot be divided by zero.");
        }
    }
}
