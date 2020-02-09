package by.epam.composite.controller.command.impl;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;

public class WrongCommand implements Command {
    @Override
    public String execute(String request, Component component) {
        return "Wrong command.";
    }
}
