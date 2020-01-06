package by.epam.classes.service;

import by.epam.classes.domain.Car;
import by.epam.classes.service.exception.EmptyListException;

import java.util.List;

public class CarsSorter {
    public List<Car> sortByCost(List<Car> cars) throws EmptyListException{
        if (cars.isEmpty()) {
            throw new EmptyListException("List of cars is empty");
        }
        CostComparator costComparator = new CostComparator();
        cars.sort(costComparator);
        return cars;
    }

    public List<Car> sortByYear(List<Car> cars) throws EmptyListException {
        if (cars.isEmpty()) {
            throw new EmptyListException("List of cars is empty");
        }
        YearComparator yearComparator = new YearComparator();
        cars.sort(yearComparator);
        return cars;
    }
}
