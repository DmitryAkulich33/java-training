package by.epam.xml.domain;

public class Pie {
    private int id;
    private String title;
    private int weight;
    private double price;
    private String description;

    public Pie() {
    }

    public Pie(int id, String title, int weight, double price, String description) {
        this.id = id;
        this.title = title;
        this.weight = weight;
        this.price = price;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pie pie = (Pie) o;

        if (id != pie.id) return false;
        if (weight != pie.weight) return false;
        if (Double.compare(pie.price, price) != 0) return false;
        if (title != null ? !title.equals(pie.title) : pie.title != null) return false;
        return description != null ? description.equals(pie.description) : pie.description == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = id;
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + weight;
        temp = Double.doubleToLongBits(price);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (description != null ? description.hashCode() : 0);
        return result;
    }
}
