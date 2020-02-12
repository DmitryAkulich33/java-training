package by.epam.composite.controller.command.impl;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;
import by.epam.composite.service.exception.ServiceException;
import by.epam.composite.service.factory.ServiceFactory;
import by.epam.composite.view.Viewer;

public class LexemeSort implements Command {
    @Override
    public String execute(String request, Component component) {
        Viewer viewer = new Viewer();
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        char letter = viewer.getLetter();
        String lexemes = serviceFactory.getLexemeService().sort(component, letter);
        try {
            serviceFactory.getTextService().writeToFileLine(lexemes, "src\\main\\resources\\task3.txt");
            response = "Text successfully saved.";
            viewer.print(lexemes);
        } catch (ServiceException ex) {
            response = ex.getMessage();
        }
        return response;
    }
}
