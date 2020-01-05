package by.epam.twodimensionalarray.view;

import by.epam.twodimensionalarray.domain.DoubleMatrix;
import by.epam.twodimensionalarray.domain.IntMatrix;

import java.util.Scanner;

public class Viewer {
    Scanner scanner = new Scanner(System.in);


    public void printMenu() {
        System.out.println("Enter the required number from the menu:");
        System.out.println(" 1 - if you want to solve exercise from Blinov's book");
        System.out.println(" 2 - if you want to solve exercise number 8");
        System.out.println(" 3 - if you want to solve exercise number 18");
        System.out.println(" 4 - if you want to solve exercise number 23");
        System.out.println(" 5 - if you want to solve exercise number 33");
        System.out.println(" 0 - if you want to exit");
    }

    public int returnNumber() {
        while (!scanner.hasNextInt()) {
            System.out.println("The entered line is not a number. Please try again");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public void printMatrixSizes() {
        System.out.println("Enter the vertical and horizontal sizes of matrix (2 numbers)");
    }

    public void printSquareMatrixSizes() {
        System.out.println("Enter the size of square matrix");
    }

    public void printValues() {
        System.out.println("Enter the minimum and maximum sizes of matrix (2 numbers)");
    }

    public void printNumber() {
        System.out.println("Enter the number for searching among elements");
    }

    public void printIntMatrix(IntMatrix intMatrix) {
        System.out.println(intMatrix);
    }

    public void printDoubleMatrix(DoubleMatrix doubleMatrix) {
        System.out.println(doubleMatrix);
    }

    public void printAnswer() {
        System.out.println("Answer:");
    }

    public void printNumberCount(int number, int count) {
        System.out.println("Number " + number + " in array: " + count);
    }

    public void printReturnToMenu() {
        System.out.println("\n Return to the menu:\n");
    }

    public void printPositiveNumbersCount(int count) {
        System.out.println("Count of positive numbers: " + count);
    }

}
