package by.epam.xml.controller.command.impl;

import by.epam.xml.controller.command.Command;
import by.epam.xml.domain.Order;
import by.epam.xml.service.ServiceParser;
import by.epam.xml.service.exception.ServiceException;
import by.epam.xml.view.Viewer;

import java.util.Set;

public class StaxParser implements Command {
    @Override
    public Set<Order> execute(String filename) {
        ServiceParser serviceParser = new ServiceParser();
        Viewer viewer = new Viewer();
        Set<Order> ordersStAX = null;
        try {
            ordersStAX = serviceParser.parseStAX(filename);
        } catch (ServiceException e) {
            viewer.printMessage(e.getMessage());
        }
        return ordersStAX;
    }
}
