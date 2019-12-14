package by.epam.wordsnumbers.runner;

import by.epam.wordsnumbers.controller.NumbersInWordsCommand;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        NumbersInWordsCommand numbersInWordsCommand = new NumbersInWordsCommand();
        numbersInWordsCommand.exec();
    }
}
