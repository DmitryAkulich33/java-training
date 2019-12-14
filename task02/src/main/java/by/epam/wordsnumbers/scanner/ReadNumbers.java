package by.epam.wordsnumbers.scanner;

import by.epam.wordsnumbers.exception.WrongNumberException;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ReadNumbers {
    public int read() {
        Scanner scanner = new Scanner(System.in);
        int number;
        System.out.println("Enter number from 0 to 9999:");
        try {
            number = scanner.nextInt();
            scanner.close();
        } catch (InputMismatchException e) {
            throw new WrongNumberException("The entered value isn't number");
        }
        if(number < 0 || number > 9999){
            throw new WrongNumberException("The entered number is wrong");
        }
        return number;
    }
}
