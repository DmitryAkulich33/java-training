package by.epam.nextdate.runner;

import by.epam.nextdate.controller.NextDateCommand;

public class Main {
    public static void main(String[] args) {
        NextDateCommand nextDateCommand = new NextDateCommand();
        nextDateCommand.exec();
    }
}
