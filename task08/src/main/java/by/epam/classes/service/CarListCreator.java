package by.epam.classes.service;

import by.epam.classes.domain.Car;
import by.epam.classes.domain.CarProducer;
import by.epam.classes.service.exception.EmptyListException;

import java.util.ArrayList;
import java.util.List;

public class CarListCreator {

    public List<Car> returnListOfCars(List<String> validLines) {
        if (validLines.isEmpty()) {
            throw new EmptyListException("List of cars is empty");
        }
        List<Car> cars = new ArrayList<>();
        int length = validLines.size();
        for (int i = 0; i < length; i++) {
            String[] valuesFromLine = validLines.get(i).split("\\s");
            cars.add(getCurrentCar(valuesFromLine));
        }
        return cars;
    }

    public Car getCurrentCar(String[] line){
        CarProducer producer = CarProducer.valueOf(line[0]);
        String model = line[1];
        int year = Integer.parseInt(line[2]);
        String color = line[3];
        int cost = Integer.parseInt(line[4]);
        String regNumber = line[5];
        return new Car(producer, model, year, color, cost, regNumber);

    }
}
