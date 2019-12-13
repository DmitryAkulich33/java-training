package by.epam.exercise33.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number:");
        number = scanner.nextInt();
        scanner.close();
        int maximum = 0;
        while (number > 0) {
            if (number % 10 > maximum) {
                maximum = number % 10;
            }
            number = number / 10;
        }
        System.out.println("The largest digit of the number is: " + maximum);
    }
}
