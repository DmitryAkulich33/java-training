package by.epam.exercise08.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        int a;
        int b;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a:");
        a = scanner.nextInt();
        System.out.println("Enter b:");
        b = scanner.nextInt();
        scanner.close();
        if (a * a > b * b) {
            System.out.println("Answer: " + (b * b));
        } else {
            System.out.println("Answer: " + (a * a));
        }
    }
}
