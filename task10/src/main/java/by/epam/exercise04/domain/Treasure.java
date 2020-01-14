package by.epam.exercise04.domain;

public abstract class Treasure {
    private String name;
    private int cost;
    private MaterialType type;

    public Treasure() {
    }

    public Treasure(String name, int cost, MaterialType type) {
        this.name = name;
        this.cost = cost;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public MaterialType getType() {
        return type;
    }

    public void setType(MaterialType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Treasure treasure = (Treasure) o;

        if (cost != treasure.cost) return false;
        if (name != null ? !name.equals(treasure.name) : treasure.name != null) return false;
        return type == treasure.type;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + cost;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Name: " + name + "  cost: " + cost + "  type:" + type;
    }
}
