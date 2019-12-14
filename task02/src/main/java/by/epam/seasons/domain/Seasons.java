package by.epam.seasons.domain;

public enum Seasons {
    WINTER("Winter"),
    SPRING("Spring"),
    SUMMER("Summer"),
    AUTUMN("Autumn");

    private String value;

    Seasons(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
