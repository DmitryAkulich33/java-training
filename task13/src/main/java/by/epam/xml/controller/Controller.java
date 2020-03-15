package by.epam.xml.controller;

import by.epam.xml.controller.command.Command;
import by.epam.xml.domain.Order;
import by.epam.xml.service.Director;
import by.epam.xml.service.builder.OrderDOMBuilder;
import by.epam.xml.service.builder.OrderSAXBuilder;
import by.epam.xml.service.builder.OrderStAXBuilder;
import by.epam.xml.view.Viewer;

import java.util.Set;

public final class Controller {
    private CommandProvider commandProvider = new CommandProvider();

    public Set<Order> execute(String request, String filename){
        Command executionCommand = commandProvider.getCommand(request);
        return executionCommand.execute(filename);
    }
}
