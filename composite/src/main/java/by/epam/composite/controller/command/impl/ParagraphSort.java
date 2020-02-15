package by.epam.composite.controller.command.impl;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;
import by.epam.composite.service.exception.ServiceException;
import by.epam.composite.service.factory.ServiceFactory;
import by.epam.composite.view.Viewer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ParagraphSort implements Command {
    private static Logger log = LogManager.getLogger(ParagraphSort.class.getName());

    @Override
    public String execute(String request, Component component) {
        Viewer viewer = new Viewer();
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Component newComponent = serviceFactory.getParagraphService().sort(component);
        try {
            serviceFactory.getTextService().writeToFileComponent(newComponent, "src\\main\\resources\\composite\\task1.txt");
            response = "Text successfully sorted and saved.";
            viewer.print(newComponent);
            log.info("Text successfully sorted and saved.");
        } catch (ServiceException ex) {
            response = ex.getMessage();
            log.error(ex.getMessage());
        }
        return response;
    }
}
