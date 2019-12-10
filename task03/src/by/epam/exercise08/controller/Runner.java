package by.epam.exercise08.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        double lineStart;
        double lineEnd;
        double step;
        double c;
        double x;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the start of line:");
        lineStart = scanner.nextDouble();
        System.out.println("Enter the end of line:");
        lineEnd = scanner.nextDouble();
        System.out.println("Enter c:");
        c = scanner.nextDouble();
        System.out.println("Enter step of value changes:");
        step = scanner.nextDouble();
        scanner.close();
        x = lineStart;
        while (x < lineEnd) {
            if (x == 15) {
                System.out.println("x = " + x + ", y = " + ((x + c) * 2));
            } else {
                System.out.println("x = " + x + ", y = " + ((x - c) + 2));
            }
            x += step;
        }
    }
}
