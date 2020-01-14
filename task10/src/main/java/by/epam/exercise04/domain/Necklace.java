package by.epam.exercise04.domain;

public class Necklace extends Treasure {
    private int length;

    public Necklace() {
    }

    public Necklace(String name, int cost, MaterialType type, int length) {
        super(name, cost, type);
        this.length = length;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Necklace necklace = (Necklace) o;

        return length == necklace.length;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + length;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "  necklace length:" + length;
    }
}
