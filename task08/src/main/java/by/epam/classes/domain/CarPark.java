package by.epam.classes.domain;

import java.util.List;

public class CarPark {
    private String title;
    private List<Car> cars;

    public CarPark(String title, List<Car> cars) {
        this.title = title;
        this.cars = cars;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    @Override
    public String toString() {
        String line = "MY CAR PARK:\n\n";
        for (Car car: cars) {
            line = line + car +"\n";
        }
        return line;
    }
}
