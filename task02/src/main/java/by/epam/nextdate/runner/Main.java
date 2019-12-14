package by.epam.nextdate.runner;

import by.epam.nextdate.controller.DateCreator;
import by.epam.nextdate.controller.NextDateCommand;
import by.epam.nextdate.domain.Date;
import by.epam.nextdate.scanner.ReadDate;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        NextDateCommand nextDateCommand = new NextDateCommand();
        nextDateCommand.exec();
    }
}
