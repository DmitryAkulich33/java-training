package by.epam.exercise04.controller.command.impl;

import by.epam.exercise04.controller.command.Command;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.domain.Treasure;
import by.epam.exercise04.service.TreasureService;
import by.epam.exercise04.service.exception.EmptyListException;
import by.epam.exercise04.service.exception.WrongNumberException;
import by.epam.exercise04.service.factory.ServiceFactory;
import by.epam.exercise04.view.Viewer;

import java.util.List;

public class TakenTreasure implements Command {
    @Override
    public String execute(String request, DragonCave dragonCave) {
        String response;
        Viewer viewer = new Viewer();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        TreasureService treasureService = serviceFactory.getTreasureService();
        int sum = viewer.returnNumber();
        List<Treasure> treasures = null;
        try {
            treasures = treasureService.selectTreasure(dragonCave, sum);
            treasureService.deleteTreasures(treasures, dragonCave);
            response = "Treasures were taken successfully.";
            viewer.printTreasure(treasures);
        } catch (WrongNumberException | EmptyListException ex) {
            response = ex.getMessage();
        }
        return response;
    }
}
