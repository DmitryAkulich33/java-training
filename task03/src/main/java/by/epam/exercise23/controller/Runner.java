package by.epam.exercise23.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        double lineStart;
        double lineEnd;
        double step;
        double x;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the start of line:");
        lineStart = scanner.nextDouble();
        System.out.println("Enter the end of line:");
        lineEnd = scanner.nextDouble();
        System.out.println("Enter step of value changes:");
        step = scanner.nextDouble();
        scanner.close();
        x = lineStart;
        System.out.printf("%4s%10s%n", "x", "F(x)");
        while (x < lineEnd) {
            System.out.printf("%6.2f%8.2f%n", x, (1.0 / Math.tan(x / 3)) + (Math.sin(x) / 2));
            x += step;
        }
    }
}
