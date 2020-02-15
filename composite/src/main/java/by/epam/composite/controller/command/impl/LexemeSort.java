package by.epam.composite.controller.command.impl;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;
import by.epam.composite.service.exception.ServiceException;
import by.epam.composite.service.factory.ServiceFactory;
import by.epam.composite.view.Viewer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LexemeSort implements Command {
    private static Logger log = LogManager.getLogger(LexemeSort.class.getName());

    @Override
    public String execute(String request, Component component) {
        Viewer viewer = new Viewer();
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        char letter = viewer.getLetter();
        String lexemes = serviceFactory.getLexemeService().sort(component, letter);
        try {
            serviceFactory.getTextService().writeToFileLine(lexemes, "src\\main\\resources\\composite\\task3.txt");
            response = "Text successfully sorted and saved.";
            viewer.print(lexemes);
            log.info("Text successfully sorted and saved.");
        } catch (ServiceException ex) {
            response = ex.getMessage();
            log.error(ex.getMessage());
        }
        return response;
    }
}
