package by.epam.exercise02.controller;

import by.epam.exercise02.controller.command.Command;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.service.creator.ShopCreator;
import by.epam.exercise02.service.exception.NoProductsForSaleException;

public final class Controller {
    private final CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String productNames, String request, Shop shop) {
        Command executionCommand = commandProvider.getCommand(request);
        return executionCommand.execute(productNames, request, shop);
    }

    public Shop createShop(String name, String path) {
        Shop shop = null;
        ShopCreator shopCreator = new ShopCreator();
        try {
            shop = shopCreator.createShop(name, path);
        } catch (NoProductsForSaleException e) {
            System.out.println(e.getMessage());
        }
        return shop;
    }
}
