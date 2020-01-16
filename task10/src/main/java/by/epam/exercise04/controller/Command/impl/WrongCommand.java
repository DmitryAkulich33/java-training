package by.epam.exercise04.controller.Command.impl;

import by.epam.exercise04.controller.Command.Command;
import by.epam.exercise04.domain.DragonCave;

public class WrongCommand implements Command {
    @Override
    public String execute(String request, DragonCave dragonCave) {
        return "Wrong Command.";
    }
}
