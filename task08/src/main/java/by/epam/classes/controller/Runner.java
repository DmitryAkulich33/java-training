package by.epam.classes.controller;

import by.epam.classes.dao.LinesReader;
import by.epam.classes.domain.Car;
import by.epam.classes.domain.CarPark;
import by.epam.classes.domain.CarProducer;
import by.epam.classes.domain.CommonConstants;
import by.epam.classes.service.CarFinder;
import by.epam.classes.service.CarListCreator;
import by.epam.classes.service.CarsSorter;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        LinesReader linesReader = new LinesReader();
        CarListCreator carListCreator = new CarListCreator();
        List<String> list = linesReader.returnListCarsFromFile(CommonConstants.PATH_CARS_DATA);
        List<Car> cars = carListCreator.returnListOfCars(list);
        CarPark carPark = new CarPark(CommonConstants.PARK_TITLE, cars);
        System.out.println(carPark);
        CarFinder carFinder = new CarFinder();
        for (Car car: carFinder.returnCarListWithNecessaryProducer(cars, CarProducer.BMW)) {
            System.out.println(car);
        }
        System.out.println();
        for (Car car: carFinder.returnCarListWithNecessaryAge(cars, CarProducer.FORD, CommonConstants.NECESSARY_AGE)) {
            System.out.println(car);
        }
        System.out.println();
        for (Car car: carFinder.returnCarListWithNecessaryCost(cars, CommonConstants.NECESSARY_YEAR, CommonConstants.NECESSARY_COST)) {
            System.out.println(car);
        }
        System.out.println();
        CarsSorter carsSorter = new CarsSorter();
        for (Car car: carsSorter.sortByCost(cars)) {
            System.out.println(car);
        }
        System.out.println();
        for (Car car: carsSorter.sortByYear(cars)) {
            System.out.println(car);
        }
        System.out.println();
    }
}
