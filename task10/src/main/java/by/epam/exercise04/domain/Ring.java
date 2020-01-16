package by.epam.exercise04.domain;

public class Ring extends Treasure {
    private int size;

    public Ring() {
    }

    public Ring(String name, int cost, String materialType, int size) {
        super(name, cost, materialType);
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        Ring ring = (Ring) o;

        return size == ring.size;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        return super.toString() + "  ring size: " + size;
    }
}
