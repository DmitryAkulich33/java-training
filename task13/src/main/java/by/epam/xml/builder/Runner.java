package by.epam.xml.builder;

import by.epam.xml.parser.OrderDOMBuilder;
import by.epam.xml.parser.OrderSAXBuilder;
import by.epam.xml.parser.OrderStAXBuilder;

public class Runner {
    public static void main(String[] args) {
        OrderSAXBuilder saxBuilder = new OrderSAXBuilder();
        saxBuilder.buildSetOrders("src/main/resources/xml/orders.xml");
        System.out.println(saxBuilder.getOrders());
        System.out.println();
        OrderDOMBuilder domBuilder = new OrderDOMBuilder();
        domBuilder.buildSetOrders("src/main/resources/xml/orders.xml");
        System.out.println(domBuilder.getOrders());
        System.out.println();
        OrderStAXBuilder staxBuilder = new OrderStAXBuilder();
        staxBuilder.buildSetOrders("src/main/resources/xml/orders.xml");
        System.out.println(staxBuilder.getOrders());
    }
}
