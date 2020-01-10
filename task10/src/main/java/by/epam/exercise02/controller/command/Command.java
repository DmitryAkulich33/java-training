package by.epam.exercise02.controller.command;

import by.epam.exercise02.domain.Shop;

public interface Command {
    public String execute(String productNames, String request, Shop shop);
}
