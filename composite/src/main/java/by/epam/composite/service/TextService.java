package by.epam.composite.service;

import by.epam.composite.domain.Component;
import by.epam.composite.service.exception.ServiceException;

public interface TextService {
    String readFromFile(String path) throws ServiceException;

    Component divideIntoComponents(String text) throws ServiceException;

    void writeToFile(Component component, String path) throws ServiceException;
}
