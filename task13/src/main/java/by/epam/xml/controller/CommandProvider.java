package by.epam.xml.controller;

import by.epam.xml.controller.command.Command;
import by.epam.xml.controller.command.CommandName;
import by.epam.xml.controller.command.impl.DomParser;
import by.epam.xml.controller.command.impl.SaxParser;
import by.epam.xml.controller.command.impl.StaxParser;
import by.epam.xml.controller.command.impl.WrongCommand;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.DOM, new DomParser());
        repository.put(CommandName.SAX, new SaxParser());
        repository.put(CommandName.STAX, new StaxParser());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
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
