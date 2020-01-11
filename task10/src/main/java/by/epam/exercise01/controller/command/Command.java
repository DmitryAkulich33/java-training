package by.epam.exercise01.controller.command;

import by.epam.exercise01.domain.Directory;

public interface Command {
    String execute(String request, Directory directory);
}
