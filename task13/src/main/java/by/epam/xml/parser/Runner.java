package by.epam.xml.parser;

import by.epam.xml.xmlorders.OrderDOMHandler;

public class Runner {
    public static void main(String[] args) {
        OrderSAXBuilder saxBuilder = new OrderSAXBuilder();
        saxBuilder.buildSetOrders("src/main/resources/xml/orders.xml");
        System.out.println(saxBuilder.getOrders());
        System.out.println();
        OrderDOMHandler domBuilder = new OrderDOMHandler();
        domBuilder.buildSetOrders("src/main/resources/xml/orders.xml");
        System.out.println(domBuilder.getOrders());
    }
}
