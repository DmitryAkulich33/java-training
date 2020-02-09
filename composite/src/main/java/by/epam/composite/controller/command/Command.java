package by.epam.composite.controller.command;

import by.epam.composite.domain.Component;

public interface Command {
    String execute(String request, Component component);
}
