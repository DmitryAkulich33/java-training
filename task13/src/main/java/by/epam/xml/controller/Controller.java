package by.epam.xml.controller;

import by.epam.xml.domain.Order;
import by.epam.xml.service.Director;
import by.epam.xml.service.builder.OrderDOMBuilder;
import by.epam.xml.service.builder.OrderSAXBuilder;
import by.epam.xml.service.builder.OrderStAXBuilder;
import by.epam.xml.view.Viewer;

import java.util.Set;

public final class Controller {
    public void execute(String filename){
        Viewer viewer = new Viewer();
        Set<Order> ordersDOM = Director.createOrders(new OrderDOMBuilder(), filename);
        Set<Order> ordersSAX = Director.createOrders(new OrderSAXBuilder(), filename);
        Set<Order> ordersStAX = Director.createOrders(new OrderStAXBuilder(), filename);
        viewer.printOrders(ordersDOM);
        viewer.printOrders(ordersSAX);
        viewer.printOrders(ordersStAX);
    }
}
