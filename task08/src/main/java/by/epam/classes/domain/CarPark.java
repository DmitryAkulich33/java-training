package by.epam.classes.domain;

import java.util.List;

public class CarPark {
    private static CarPark instance;
    private String title;
    private List<Car> cars;

    private CarPark(String title, List<Car> cars) {
        this.title = title;
        this.cars = cars;
    }

    public static CarPark getInstance(String title, List<Car> list) {
        if (instance == null) {
            instance = new CarPark(title, list);
        }
        return instance;
    }

    public String getTitle() {
        return title;
    }

    public List<Car> getCars() {
        return cars;
    }

    @Override
    public String toString() {
        String line = title + ":\n";
        for (Car car : cars) {
            line = line + car + "\n";
        }
        return line;
    }
}
