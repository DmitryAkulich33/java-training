package by.epam.exercise08.scanner;

import by.epam.exercise08.exception.WrongDataException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class LengthReader {
    public int read() {
        int length;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of array");
        try {
            length = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new WrongDataException("Invalid array length");
        }
        scanner.close();
        return length;
    }
}
