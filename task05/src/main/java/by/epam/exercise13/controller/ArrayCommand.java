package by.epam.exercise13.controller;

import by.epam.exercise13.service.NumberAction;

public class ArrayCommand {
    public void exec() {
        NumberAction numberAction = new NumberAction();
        int counter = numberAction.getCount(2, 8, 2);
        System.out.println(counter);
    }
}
