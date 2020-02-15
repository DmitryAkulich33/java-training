package by.epam.composite.controller.command.impl;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;
import by.epam.composite.view.Viewer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CompileText implements Command {
    private static Logger log = LogManager.getLogger(CompileText.class.getName());

    @Override
    public String execute(String request, Component component) {
        Viewer viewer = new Viewer();
        viewer.print(component);
        log.info("Text successfully compiled and printed.");
        return "Text successfully compiled and printed.";
    }
}
