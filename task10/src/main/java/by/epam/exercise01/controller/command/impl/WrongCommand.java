package by.epam.exercise01.controller.command.impl;

import by.epam.exercise01.controller.command.Command;
import by.epam.exercise01.domain.Directory;

public class WrongCommand implements Command {
    @Override
    public String execute(String request, Directory directory) {
        return "Wrong command.";
    }
}
