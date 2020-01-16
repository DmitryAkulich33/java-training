package by.epam.exercise04.domain;

import java.util.List;

public class DragonCave {
    private List<Treasure> treasures;

    public DragonCave(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    public DragonCave() {
    }

    public List<Treasure> getTreasures() {
        return treasures;
    }

    public void setTreasures(List<Treasure> treasures) {
        this.treasures = treasures;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DragonCave that = (DragonCave) o;

        return treasures != null ? treasures.equals(that.treasures) : that.treasures == null;
    }

    @Override
    public int hashCode() {
        return treasures != null ? treasures.hashCode() : 0;
    }

    @Override
    public String toString() {
        StringBuilder line = new StringBuilder();
        for (Treasure treasure : treasures) {
            line.append(treasure).append("\n");
        }
        return line.toString();
    }
}
