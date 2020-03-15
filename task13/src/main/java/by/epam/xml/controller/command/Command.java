package by.epam.xml.controller.command;

import by.epam.xml.domain.Order;

import java.util.Set;

public interface Command {
    Set<Order> execute(String filename);
}
