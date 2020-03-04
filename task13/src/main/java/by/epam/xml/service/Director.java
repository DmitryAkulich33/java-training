package by.epam.xml.service;

import by.epam.xml.domain.Order;
import by.epam.xml.service.builder.BaseBuilder;

import java.util.Set;

public class Director {
    public static Set<Order> createOrders(BaseBuilder builder, String filename) {
        builder.buildSetOrders(filename);
        return builder.getOrders();
    }
}
