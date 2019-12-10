package by.epam.exercise23.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        double outerRadius;
        double innerRadius;
        double ringArea;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the outer radius:");
        outerRadius = scanner.nextDouble();
        System.out.println("Enter the inner radius:");
        innerRadius = scanner.nextDouble();
        scanner.close();
        if (outerRadius > innerRadius) {
            ringArea = (Math.PI * outerRadius * outerRadius) - (Math.PI * innerRadius * innerRadius);
            System.out.println("The ring area is: " + ringArea);
        } else {
            System.out.println("The entered data is incorrect.");
        }
    }
}
