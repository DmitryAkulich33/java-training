package by.epam.classes.service;

import by.epam.classes.domain.Car;

import java.util.Comparator;

public class CostComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getCost() == o2.getCost()) {
            return 0;
        } else if (o1.getCost() > o2.getCost()) {
            return 1;
        } else {
            return -1;
        }
    }
}
