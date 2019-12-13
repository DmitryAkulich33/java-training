package by.epam.exercise18.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        int a;
        int b;
        int c;
        int count = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a:");
        a = scanner.nextInt();
        System.out.println("Enter b:");
        b = scanner.nextInt();
        System.out.println("Enter c:");
        c = scanner.nextInt();
        scanner.close();
        if (a < 0) {
            count++;
        }
        if (b < 0) {
            count++;
        }
        if (c < 0) {
            count++;
        }
        System.out.println("Number of negative numbers: " + count);
    }
}
