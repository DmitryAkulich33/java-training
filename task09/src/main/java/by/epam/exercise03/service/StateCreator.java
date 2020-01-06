package by.epam.exercise03.service;

import by.epam.exercise03.domain.*;
import by.epam.exercise03.service.exception.EmptyListException;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StateCreator {
    public State returnState (String name, String capital, List<String> linesFromFile){
        List<String> regionNames = findListRegionNames(linesFromFile);
        List<String> districtNames = findListDistrictsNames(linesFromFile);
        List<Region> regions = new ArrayList<>();
        int sizeReg = regionNames.size();
        int sizeDist = districtNames.size();
        int sizeLines = linesFromFile.size();
        for(int i = 0; i < sizeReg; i++){
            List<District> districts = new ArrayList<>();
            for(int j = 0; j < sizeDist; j++){
                List<City> cities = new ArrayList<>();
                for (int k = 0; k < sizeLines; k++){
                    String[] array = linesFromFile.get(k).split(",\\s");
                    int square = Integer.parseInt(array[3]);
                    if(array[0].equals(regionNames.get(i))){
                        if(array[1].equals(districtNames.get(j))){
                            cities.add(new City(array[2], square));
                        }
                    }
                }
                if(!cities.isEmpty()) {
                    districts.add(new District(districtNames.get(j), cities));
                }
            }
            String regionCity = returnRegionalCity(regionNames.get(i));
            regions.add(new Region(regionNames.get(i), regionCity, districts));
        }
        return new State(name, capital, regions);
    }

    public List<String> findListRegionNames(List<String> linesFromFile) throws EmptyListException {
        if (linesFromFile.isEmpty()) {
            throw new EmptyListException("List from file is empty");
        }
        List<String> regNames = new ArrayList<>();
        Set<String> sortedNames = new HashSet<>();
        for (String line : linesFromFile) {
            String[] array = line.split(",\\s");
            sortedNames.add(array[0]);
        }
        regNames.addAll(sortedNames);
        return regNames;
    }

    public List<String> findListDistrictsNames(List<String> linesFromFile) throws EmptyListException{
        if (linesFromFile.isEmpty()) {
            throw new EmptyListException("List from file is empty");
        }
        List<String> distNames = new ArrayList<>();
        Set<String> sortedNames = new HashSet<>();
        for (String line : linesFromFile) {
            String[] array = line.split(",\\s");
            sortedNames.add(array[1]);
        }
        distNames.addAll(sortedNames);
        return distNames;
    }

    public String returnRegionalCity(String name) {
        String regionalCity = "";
        switch (name) {
            case "Brestskaya":
                regionalCity = "Brest";
                break;
            case "Mogilevskaya":
                regionalCity = "Mogilev";
                break;
            case "Minskaya":
                regionalCity = "Minsk";
                break;
        }
        return regionalCity;
    }
}
