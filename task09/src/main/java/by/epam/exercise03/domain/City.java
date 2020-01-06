package by.epam.exercise03.domain;

public class City {
    private String name;
    private int square;

    public City(String name, int square) {
        this.name = name;
        this.square = square;
    }

    public City() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSquare() {
        return square;
    }

    public void setSquare(int square) {
        this.square = square;
    }

    @Override
    public String toString() {
        return name + " city (" + square + " m.kv)";
    }
}
