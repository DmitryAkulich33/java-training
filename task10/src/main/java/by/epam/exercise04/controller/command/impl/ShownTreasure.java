package by.epam.exercise04.controller.command.impl;

import by.epam.exercise04.controller.command.Command;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.view.Viewer;

public class ShownTreasure implements Command {
    @Override
    public String execute(String request, DragonCave dragonCave) {
        Viewer viewer = new Viewer();
        viewer.printTreasure(dragonCave.getTreasures());
        return "Treasure list successfully printed";
    }
}
