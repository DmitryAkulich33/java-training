package by.epam.bakery.domain;

public class Status extends Entity{
    private String name;

    public Status() {
    }

    public Status(int id, String name) {
        super(id);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Status" + super.toString() + ", name:" + name;
    }
}
