package by.epam.xml.builder;

import by.epam.xml.domain.Order;
import by.epam.xml.view.Viewer;

import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        String filename = "src/main/resources/xml/orders.xml";
        Set<Order> ordersDOM = Director.createOrders(new OrderDOMBuilder(), filename);
        Set<Order> ordersSAX = Director.createOrders(new OrderSAXBuilder(), filename);
        Set<Order> ordersStAX = Director.createOrders(new OrderStAXBuilder(), filename);
        viewer.printOrders(ordersDOM);
        viewer.printOrders(ordersSAX);
        viewer.printOrders(ordersStAX);
    }
}
