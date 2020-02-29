package by.epam.xml.view;

import by.epam.xml.domain.Order;

import java.util.Set;

public class Viewer {
    public void printOrders(Set<Order> orders) {
        for (Order order : orders) {
            System.out.println(order);
        }
        System.out.println();
    }
}
