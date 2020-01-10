package by.epam.exercise02.controller;

import by.epam.exercise02.controller.command.Command;
import by.epam.exercise02.controller.command.CommandName;
import by.epam.exercise02.controller.command.impl.DecreasingBill;
import by.epam.exercise02.controller.command.impl.IncreasingBill;
import by.epam.exercise02.controller.command.impl.StandardBill;
import by.epam.exercise02.controller.command.impl.WrongCommand;

import java.util.HashMap;
import java.util.Map;

final class CommandProvider {
    private final Map<CommandName, Command> repository = new HashMap<>();

    CommandProvider(){
        repository.put(CommandName.STANDARD, new StandardBill());
        repository.put(CommandName.INCREASE, new IncreasingBill());
        repository.put(CommandName.DECREASE, new DecreasingBill());
        repository.put(CommandName.WRONG_COMMAND, new WrongCommand());
    }
     Command getCommand(String name){
        CommandName commandName = null;
        Command command = null;
        try{
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException ex){
            command = repository.get(CommandName.WRONG_COMMAND);
        }
        return command;
     }
}
