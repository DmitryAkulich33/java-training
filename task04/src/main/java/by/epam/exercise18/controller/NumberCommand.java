package by.epam.exercise18.controller;

import by.epam.exercise18.service.ArrayAction;
import by.epam.exercise18.scanner.NumberReader;


public class NumberCommand {
    public void exec() {
        NumberReader numberReader = new NumberReader();
        int number = numberReader.read();
        ArrayAction arrayAction = new ArrayAction();
        System.out.println(arrayAction.returnArray(number, 1));
    }
}
