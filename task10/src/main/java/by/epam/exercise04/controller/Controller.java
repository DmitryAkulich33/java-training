package by.epam.exercise04.controller;

import by.epam.exercise04.controller.command.Command;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.service.DragonCaveService;
import by.epam.exercise04.service.exception.EmptyListException;
import by.epam.exercise04.service.exception.ServiceException;
import by.epam.exercise04.service.factory.ServiceFactory;

public final class Controller {
    private CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request, DragonCave dragonCave) {
        Command executionCommand = commandProvider.getCommand(request);
        return executionCommand.execute(request, dragonCave);
    }

    public DragonCave createDragonCave(String path) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        DragonCaveService dragonCaveService = serviceFactory.getDragonCaveService();
        DragonCave dragonCave = null;
        try {
            dragonCave = dragonCaveService.createDragonCave(path);
        } catch (ServiceException | EmptyListException ex) {
            System.out.println(ex.getMessage());
        }
        return dragonCave;
    }
}
