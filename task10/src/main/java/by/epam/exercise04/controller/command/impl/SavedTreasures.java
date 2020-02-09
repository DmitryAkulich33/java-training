package by.epam.exercise04.controller.command.impl;

import by.epam.exercise04.controller.command.Command;
import by.epam.exercise04.domain.Constants;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.service.DragonCaveService;
import by.epam.exercise04.service.exception.ServiceException;
import by.epam.exercise04.service.factory.ServiceFactory;

public class SavedTreasures implements Command {
    @Override
    public String execute(String request, DragonCave dragonCave) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        try {
            serviceFactory.getDragonCaveService().saveTreasureInFile(dragonCave, Constants.SAVING_TREASURE_LIST_PATH);
            response = "Treasure list successfully saved.";
        } catch (ServiceException ex) {
            response = ex.getMessage();
        }
        return response;
    }
}
