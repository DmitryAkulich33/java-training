package by.epam.xml.service;

import by.epam.xml.domain.Order;
import by.epam.xml.service.builder.OrderDOMBuilder;
import by.epam.xml.service.builder.OrderSAXBuilder;
import by.epam.xml.service.builder.OrderStAXBuilder;
import by.epam.xml.service.exception.ServiceException;
import by.epam.xml.service.validator.ValidatorXSD;

import java.util.Set;

public class ServiceParser {
    private ValidatorXSD validatorXSD = new ValidatorXSD();

    public Set<Order> parseDOM(String fileName) throws ServiceException {
        if(validatorXSD.isValid(fileName)) {
            return Director.createOrders(new OrderDOMBuilder(), fileName);
        } else {
            throw new ServiceException("validation "+ fileName + " is not valid");
        }
    }

    public Set<Order> parseSAX(String fileName) throws ServiceException {
        if(validatorXSD.isValid(fileName)) {
            return Director.createOrders(new OrderSAXBuilder(), fileName);
        } else {
            throw new ServiceException("validation "+ fileName + " is not valid");
        }
    }

    public Set<Order> parseStAX(String fileName) throws ServiceException {
        if(validatorXSD.isValid(fileName)) {
            return Director.createOrders(new OrderStAXBuilder(), fileName);
        } else {
            throw new ServiceException("validation "+ fileName + " is not valid");
        }
    }
}
