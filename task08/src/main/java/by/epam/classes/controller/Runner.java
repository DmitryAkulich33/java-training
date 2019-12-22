package by.epam.classes.controller;

import by.epam.classes.dao.LinesReader;
import by.epam.classes.domain.Car;
import by.epam.classes.domain.CarPark;
import by.epam.classes.service.CarListCreator;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        LinesReader linesReader = new LinesReader();
        CarListCreator carListCreator = new CarListCreator();
        List<String> list = linesReader.returnListCarsFromFile("src\\main\\resources\\cars.txt");
        List<Car> cars = carListCreator.returnListOfCars(list);
        CarPark carPark = new CarPark("MyPark", cars);
        System.out.println(carPark);
    }
}
