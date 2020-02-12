package by.epam.composite.controller;

import by.epam.composite.controller.command.Command;
import by.epam.composite.controller.command.CommandName;
import by.epam.composite.controller.command.impl.*;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
        repository.put(CommandName.LEXEME, new LexemeSort());
        repository.put(CommandName.WORD, new WordSort());
        repository.put(CommandName.SHOW, new CompileText());
        repository.put(CommandName.PARAGRAPH, new ParagraphSort());
    }

    Command getCommand(String name) {
        CommandName commandName;
        Command command;
        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException ex) {
            command = repository.get(CommandName.WRONG_COMMAND);
        }
        return command;
    }
}

