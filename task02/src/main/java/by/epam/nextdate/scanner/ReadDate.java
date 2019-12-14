package by.epam.nextdate.scanner;

import by.epam.nextdate.exception.WrongDateException;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ReadDate {
    public List<Integer> read() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();
        int buff;
        try {
            System.out.println("Enter a day:");
            buff = scanner.nextInt();
            numbers.add(buff);
            System.out.println("Enter a number of month:");
            buff = scanner.nextInt();
            numbers.add(buff);
            System.out.println("Enter a year:");
            buff = scanner.nextInt();
            numbers.add(buff);
        } catch (InputMismatchException e) {
            throw new WrongDateException("The entered value isn't number");
        }
        return numbers;
    }
}

