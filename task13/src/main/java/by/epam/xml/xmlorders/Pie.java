package by.epam.xml.xmlorders;

public class Pie {
    private int id;
    private String title;
    private int weight;
    private double price;
    private String description;

    public Pie() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "(id: " + id +
                ", name:" + title +
                ", weight: " + weight +
                ", price: " + price +
                ", description: " + description + ")";
    }
}
