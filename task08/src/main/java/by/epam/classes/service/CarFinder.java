package by.epam.classes.service;

import by.epam.classes.domain.Car;
import by.epam.classes.domain.CarProducer;
import by.epam.classes.domain.Constants;
import by.epam.classes.service.exception.EmptyListException;

import java.util.ArrayList;
import java.util.List;

public class CarFinder {

    public List<Car> returnCarListWithNecessaryProducer(List<Car> cars, CarProducer producer) {
        List<Car> sortedCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getProducer() == producer) {
                sortedCars.add(car);
            }
        }
        if (sortedCars.isEmpty()) {
            throw new EmptyListException("The car with the necessary producer was not found.");
        }
        return sortedCars;
    }

    public List<Car> returnCarListWithNecessaryAge(List<Car> cars, CarProducer producer, int age) {
        List<Car> sortedCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getProducer() == producer && Constants.CURRENT_YEAR - car.getYear() >= age) {
                sortedCars.add(car);
            }
        }
        if (sortedCars.isEmpty()) {
            throw new EmptyListException("The car with the necessary age was not found.");
        }
        return sortedCars;
    }

    public List<Car> returnCarListWithNecessaryCost(List<Car> cars, int year, int cost) {
        List<Car> sortedCars = new ArrayList<>();
        for (Car car : cars) {
            if (car.getYear() == year && car.getCost() > cost) {
                sortedCars.add(car);
            }
        }
        if (sortedCars.isEmpty()) {
            throw new EmptyListException("The car with the necessary cost was not found.");
        }
        return sortedCars;
    }

}
