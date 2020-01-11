package by.epam.exercise01.controller;

import by.epam.exercise01.controller.command.Command;
import by.epam.exercise01.domain.Directory;

public final class Controller {
    private CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request, Directory directory) {
        Command executionCommand = commandProvider.getCommand(request);
        return executionCommand.execute(request, directory);
    }
}
