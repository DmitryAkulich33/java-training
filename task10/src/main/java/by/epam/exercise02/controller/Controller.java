package by.epam.exercise02.controller;

import by.epam.exercise02.controller.command.Command;
import by.epam.exercise02.domain.Shop;

public final class Controller {
    private final CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String productNames, String request, Shop shop){
        Command executionCommand = commandProvider.getCommand(request);
        return executionCommand.execute(productNames, request, shop);
    }
}
