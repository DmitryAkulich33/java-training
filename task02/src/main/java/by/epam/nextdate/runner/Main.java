package by.epam.nextdate.runner;

import by.epam.nextdate.controller.DateCreator;
import by.epam.nextdate.domain.Date;
import by.epam.nextdate.scanner.ReadDate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadDate readDate = new ReadDate();
        List<Integer> testList = readDate.read();

        DateCreator dateCreator = new DateCreator();
        Date checkedDate = dateCreator.create(testList);
        System.out.println(checkedDate);

    }
}
