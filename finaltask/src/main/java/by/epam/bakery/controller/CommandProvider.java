package by.epam.bakery.controller;

import by.epam.bakery.controller.command.Command;
import by.epam.bakery.controller.command.CommandName;
import by.epam.bakery.controller.command.impl.LoginCommand;
import by.epam.bakery.controller.command.impl.ShowMainPageCommand;
import by.epam.bakery.controller.command.impl.WrongCommand;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.service.impl.PieServiceImpl;
import by.epam.bakery.service.impl.UserServiceImpl;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider() {
        repository.put(CommandName.SHOW_MAIN_PAGE, new ShowMainPageCommand());
        repository.put(CommandName.LOGIN, new LoginCommand());
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
