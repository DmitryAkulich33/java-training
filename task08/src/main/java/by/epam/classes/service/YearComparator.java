package by.epam.classes.service;

import by.epam.classes.domain.Car;

import java.util.Comparator;

public class YearComparator implements Comparator<Car> {
    @Override
    public int compare(Car o1, Car o2) {
        if (o1.getYear() == o2.getYear()) {
            return 0;
        } else if (o1.getYear() > o2.getYear()) {
            return 1;
        } else {
            return -1;
        }
    }
}
