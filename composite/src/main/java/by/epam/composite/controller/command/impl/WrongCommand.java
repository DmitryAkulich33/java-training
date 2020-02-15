package by.epam.composite.controller.command.impl;

import by.epam.composite.controller.command.Command;
import by.epam.composite.domain.Component;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WrongCommand implements Command {
    private static Logger log = LogManager.getLogger(WordSort.class.getName());

    @Override
    public String execute(String request, Component component) {
        log.info("Wrong command.");
        return "Wrong command.";
    }
}
