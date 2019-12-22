package by.epam.classes.service;

import by.epam.classes.domain.Car;
import by.epam.classes.domain.CarProducer;
import by.epam.classes.service.exception.EmptyListException;

import java.util.ArrayList;
import java.util.List;

public class CarFinder {

    public List<Car> returnNecessaryProducer(List<Car> cars, CarProducer producer){
        List<Car> sortedCars = new ArrayList<>();
        for (Car car: cars) {
            if(car.getProducer() == producer){
                sortedCars.add(car);
            }
        }
        if(sortedCars.isEmpty()){
            throw new EmptyListException("The car with the necessary producer was not found.");
        }
        return sortedCars;
    }
}
