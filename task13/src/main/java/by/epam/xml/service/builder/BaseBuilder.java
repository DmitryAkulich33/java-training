package by.epam.xml.service.builder;

import by.epam.xml.domain.Order;

import java.util.HashSet;
import java.util.Set;

public abstract class BaseBuilder {
    private Set<Order> orders = new HashSet<>();

    public abstract void buildSetOrders(String fileName);

    public Set<Order> getOrders() {
        return orders;
    }
}
