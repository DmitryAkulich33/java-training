package by.epam.composite.controller.command.impl;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;
import by.epam.composite.service.exception.ServiceException;
import by.epam.composite.service.factory.ServiceFactory;
import by.epam.composite.view.Viewer;

public class ParagraphSort implements Command {
    @Override
    public String execute(String request, Component component) {
        Viewer viewer = new Viewer();
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Component newComponent = serviceFactory.getParagraphService().sort(component);
        try {
            serviceFactory.getTextService().writeToFileComponent(newComponent, "src\\main\\resources\\task1.txt");
            response = "Text successfully saved.";
            viewer.print(newComponent);
        } catch (ServiceException ex) {
            response = ex.getMessage();
        }
        return response;
    }
}
