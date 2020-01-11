package by.epam.exercise01.controller;

import by.epam.exercise01.controller.command.Command;
import by.epam.exercise01.controller.command.CommandName;
import by.epam.exercise01.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
        repository.put(CommandName.ADD, new FileAdding());
        repository.put(CommandName.MOREADD, new FileMoreAdding());
        repository.put(CommandName.CREATE, new FileCreator());
        repository.put(CommandName.DELETE, new FileDeleter());
        repository.put(CommandName.PRINT, new FileContentPrinter());
        repository.put(CommandName.RENAME, new FileRenamer());
    }

    Command getCommand(String name) {
        CommandName commandName = null;
        Command command = null;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException ex) {
            command = repository.get(CommandName.WRONG_COMMAND);
        }
        return command;
    }
}
