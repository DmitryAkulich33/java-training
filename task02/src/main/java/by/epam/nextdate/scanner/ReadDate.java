package by.epam.nextdate.scanner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ReadDate {
    public List<Integer> read() {
        Scanner scanner = new Scanner(System.in);
        List<Integer> numbers = new ArrayList<Integer>();
        System.out.println("Enter a day:");
        int buff = scanner.nextInt();
        numbers.add(buff);
        System.out.println("Enter a month:");
        buff = scanner.nextInt();
        numbers.add(buff);
        System.out.println("Enter a year:");
        buff = scanner.nextInt();
        numbers.add(buff);
        return numbers;
    }
}

