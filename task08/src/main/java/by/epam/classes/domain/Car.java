package by.epam.classes.domain;

public class Car {
    private CarProducer producer;
    private String model;
    private String year;
    private String color;
    private int cost;
    private String regNumber;

    public Car(CarProducer producer, String model, String year, String color, int cost, String regNumber) {
        this.producer = producer;
        this.model = model;
        this.year = year;
        this.color = color;
        this.cost = cost;
        this.regNumber = regNumber;
    }

    public Car() {
    }

    public CarProducer getProducer() {
        return producer;
    }

    public void setProducer(CarProducer producer) {
        this.producer = producer;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public String getRegNumber() {
        return regNumber;
    }

    public void setRegNumber(String regNumber) {
        this.regNumber = regNumber;
    }

    @Override
    public String toString() {
        return producer + " " + model + " " + year + " " + color + " " + cost + " " + regNumber;
    }
}
