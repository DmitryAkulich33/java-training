package by.epam.xml.builder;

import by.epam.xml.domain.Order;

import java.util.Set;

public class Director {
    public static Set<Order> createOrders(BaseBuilder builder, String filename) {
        builder.buildSetOrders(filename);
        return builder.getOrders();
    }
}
