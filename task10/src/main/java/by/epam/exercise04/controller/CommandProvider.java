package by.epam.exercise04.controller;

import by.epam.exercise04.controller.command.Command;
import by.epam.exercise04.controller.command.CommandName;
import by.epam.exercise04.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
        repository.put(CommandName.CHOOSE, new ChosenTreasure());
        repository.put(CommandName.SAVE, new SavedTreasures());
        repository.put(CommandName.SHOW, new ShownTreasure());
        repository.put(CommandName.TAKE, new TakenTreasure());
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
