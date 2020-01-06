package by.epam.classes.controller;

import by.epam.classes.dao.LinesReader;
import by.epam.classes.dao.LinesWriter;
import by.epam.classes.dao.exception.StreamNotReadingException;
import by.epam.classes.dao.exception.StreamNotWritingException;
import by.epam.classes.domain.Car;
import by.epam.classes.domain.CarPark;
import by.epam.classes.domain.CarProducer;
import by.epam.classes.domain.Constants;
import by.epam.classes.service.CarFinder;
import by.epam.classes.service.CarListCreator;
import by.epam.classes.service.CarsSorter;
import by.epam.classes.service.exception.EmptyListException;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        LinesReader linesReader = new LinesReader();
        CarListCreator carListCreator = new CarListCreator();
        CarFinder carFinder = new CarFinder();
        LinesWriter linesWriter = new LinesWriter();
        CarsSorter carsSorter = new CarsSorter();
        try {
            List<String> list = linesReader.returnListCarsFromFile(Constants.PATH_CARS_DATA);
            List<Car> cars = carListCreator.returnListOfCars(list);
            CarPark carPark = CarPark.getInstance(Constants.PARK_TITLE, cars);
            linesWriter.writeListCarsInFile(carPark.getCars(), Constants.PATH_EPAM_CARS);
            linesWriter.writeListCarsInFile(carFinder.returnCarListWithNecessaryProducer(carPark.getCars(), CarProducer.BMW),
                    Constants.PATH_NECESSARY_PRODUCER);
            linesWriter.writeListCarsInFile(carFinder.returnCarListWithNecessaryAge(carPark.getCars(), CarProducer.FORD, Constants.NECESSARY_AGE),
                    Constants.PATH_NECESSARY_AGE);
            linesWriter.writeListCarsInFile(carFinder.returnCarListWithNecessaryCost(carPark.getCars(), Constants.NECESSARY_YEAR, Constants.NECESSARY_COST),
                    Constants.PATH_NECESSARY_COST);
            linesWriter.writeListCarsInFile(carsSorter.sortByCost(carPark.getCars()), Constants.PATH_SORT_BY_COST);
            linesWriter.writeListCarsInFile(carsSorter.sortByYear(carPark.getCars()), Constants.PATH_SORT_BY_YEAR);
        } catch (StreamNotWritingException | StreamNotReadingException | EmptyListException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
        }
    }
}
