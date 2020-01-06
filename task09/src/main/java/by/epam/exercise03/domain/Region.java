package by.epam.exercise03.domain;


import java.util.List;

public class Region {
    private String name;
    private String regionalCity;
    private List<District> districts;

    public Region(String name, String regionalCity, List<District> districts) {
        this.name = name;
        this.regionalCity = regionalCity;
        this.districts = districts;
    }

    public Region() {
    }

    public List<District> getDistricts() {
        return districts;
    }

    public void setDistricts(List<District> districts) {
        this.districts = districts;
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
        String line = "\n" + name + " obl., region city is " + regionalCity + "\ndistricts:";
        for(District district : districts){
            line = line + "\n" + district;
        }
        return line;
    }
}
