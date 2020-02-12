package by.epam.bakery.domain;

public class Pie extends Entity {
    private String name;
    private int weight;
    private double price;
    private String description;

    public Pie() {
    }

    public Pie(int id, String name, int weight, double price, String discription) {
        super(id);
        this.name = name;
        this.weight = weight;
        this.price = price;
        this.description = discription;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDiscription() {
        return description;
    }

    public void setDiscription(String discription) {
        this.description = discription;
    }

    @Override
    public String toString() {
        return super.toString() +
                " name: " + name +
                ", weight: " + weight +
                ", price: " + price +
                ", description:" + description;
    }
}
