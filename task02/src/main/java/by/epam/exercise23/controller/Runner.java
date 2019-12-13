package by.epam.exercise23.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        int month;
        int day;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of month:");
        month = scanner.nextInt();
        System.out.println("Enter the day:");
        day = scanner.nextInt();
        scanner.close();
        if (month < 0 || month > 12) {
            System.out.println("The entered date is incorrect");
        } else if (month == 2) {
            if (day >= 1 && day <= 28) {
                System.out.println("Month number: " + month);
                System.out.println("Day: " + day);
            } else {
                System.out.println("The entered date is incorrect");
            }
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day >= 1 && day <= 30) {
                System.out.println("Month number: " + month);
                System.out.println("Day: " + day);
            } else {
                System.out.println("The entered date is incorrect");
            }
        } else {
            if (day >= 1 && day <= 31) {
                System.out.println("Month number: " + month);
                System.out.println("Day: " + day);
            } else {
                System.out.println("The entered date is incorrect");
            }
        }
    }
}
