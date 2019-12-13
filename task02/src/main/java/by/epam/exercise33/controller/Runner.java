package by.epam.exercise33.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        int password;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the password:");
        password = scanner.nextInt();
        scanner.close();
        if (password == 9583 || password == 1747) {
            System.out.println("The following base modules are available: A, B, C.");
        } else if (password == 3331 || password == 7922) {
            System.out.println("The following base modules are available: B, C.");
        } else if (password == 9455 || password == 8997) {
            System.out.println("The following base module is available: C.");
        } else {
            System.out.println("The password is wrong.");
        }
    }
}
