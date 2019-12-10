package by.epam.exercise33.controller;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        char symbol;
        int symbolIndex;
        Scanner scanner = new Scanner(System.in);
        symbol = scanner.next().charAt(0);
        scanner.close();
        symbolIndex = (int) symbol;
        System.out.println("Character is " + symbol + ", index number is " + symbolIndex);
        System.out.println("Previous character is " + (char) (symbolIndex - 1) + ", index number is " + (symbolIndex - 1));
        System.out.println("Next character is " + (char) (symbolIndex + 1) + ", index number is " + (symbolIndex + 1));
    }
}
