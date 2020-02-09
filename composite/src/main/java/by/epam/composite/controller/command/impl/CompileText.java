package by.epam.composite.controller.command.impl;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;
import by.epam.composite.view.Viewer;

public class CompileText implements Command {
    @Override
    public String execute(String request, Component component) {
        Viewer viewer = new Viewer();
        viewer.print(component);
        return "Test successfully compiled and printed.";
    }
}
