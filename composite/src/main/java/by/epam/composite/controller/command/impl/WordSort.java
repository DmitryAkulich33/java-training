package by.epam.composite.controller.command.impl;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;
import by.epam.composite.service.exception.ServiceException;
import by.epam.composite.service.factory.ServiceFactory;

public class WordSort implements Command {
    @Override
    public String execute(String request, Component component) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Component newComponent = serviceFactory.getSentenceService().sort(component);
        try {
            serviceFactory.getTextService().writeToFile(newComponent, "src\\main\\resources\\word.txt");
            response = "Text successfully saved.";
        } catch (ServiceException ex) {
            response = ex.getMessage();
        }
        return response;
    }
}
