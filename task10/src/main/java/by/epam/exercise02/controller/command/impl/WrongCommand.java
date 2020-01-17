package by.epam.exercise02.controller.command.impl;

import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.controller.command.Command;

public class WrongCommand implements Command {
    @Override
    public String execute(String productNames, String request, Shop shop) {
        return "Wrong command.";
    }
}
