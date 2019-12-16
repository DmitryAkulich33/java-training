package by.epam.exercise13.scanner;

import by.epam.exercise03.exception.WrongDataException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class NumberReader {
    public int read() {
        int number;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number");
        try {
            number = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new WrongDataException("The entered data is wrong");
        }
        return number;
    }
}
