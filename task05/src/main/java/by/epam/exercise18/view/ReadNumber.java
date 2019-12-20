package by.epam.exercise18.view;

import by.epam.exercise18.view.exception.WrongDataException;

import java.util.*;

public class ReadNumber {
    public List<Integer> getValues() {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the first index of array");
        int index1;
        int index2;
        int value1;
        int value2;
        try {
            index1 = scanner.nextInt();
            System.out.println("Enter the second index of array");
            index2 = scanner.nextInt();
            System.out.println("Enter the value array's the first index");
            value1 = scanner.nextInt();
            System.out.println("Enter the value array's the second index");
            value2 = scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new WrongDataException("The entered data is wrong");
        }
        scanner.close();
        list.add(index1);
        list.add(index2);
        list.add(value1);
        list.add(value2);
        return list;
    }
}
