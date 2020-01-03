package by.epam.exercise03.domain;


public class Region {
    String name;
    String regionalCity;

    public Region(String name, String regionalCity) {
        this.name = name;
        this.regionalCity = regionalCity;
    }

    public Region() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegionalCity() {
        return regionalCity;
    }

    public void setRegionalCity(String regionalCity) {
        this.regionalCity = regionalCity;
    }

    @Override
    public String toString() {
        return name + " obl.";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Region region = (Region) o;

        if (name != null ? !name.equals(region.name) : region.name != null) return false;
        return regionalCity != null ? regionalCity.equals(region.regionalCity) : region.regionalCity == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (regionalCity != null ? regionalCity.hashCode() : 0);
        return result;
    }
}
