package by.epam.composite.controller;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;
import by.epam.composite.service.exception.ServiceException;
import by.epam.composite.service.factory.ServiceFactory;

public final class Controller {
    private CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request, Component component) {
        Command executionCommand = commandProvider.getCommand(request);
        return executionCommand.execute(request, component);
    }

    public Component splitTextFromFile(String path) {
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Component component = null;
        try {
            component = serviceFactory.getTextService().divideIntoComponents(path);
        } catch (ServiceException ex) {
            System.out.println(ex.getMessage());
        }
        return component;
    }
}
