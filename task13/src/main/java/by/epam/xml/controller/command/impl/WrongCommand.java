package by.epam.xml.controller.command.impl;

import by.epam.xml.controller.command.Command;
import by.epam.xml.domain.Order;
import by.epam.xml.view.Viewer;

import java.util.Set;

public class WrongCommand implements Command {
    @Override
    public Set<Order> execute(String filename) {
        Viewer viewer = new Viewer();
        viewer.printMessage("Wrong command...");
        return null;
    }
}
