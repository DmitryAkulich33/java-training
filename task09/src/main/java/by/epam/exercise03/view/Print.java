package by.epam.exercise03.view;

import by.epam.exercise03.domain.Region;
import by.epam.exercise03.domain.State;


public class Print {
    public void printStateCapital(State state) {
        System.out.println("The capital of " + state.getName() + " is " + state.getCapital());
    }

    public void printStateRegions(State state) {
        System.out.print("Regions: ");
        for (Region region : state.getRegions()) {
            System.out.print(region + " ");
        }
        System.out.println();
    }

    public void printCountOfRegions(int count) {
        System.out.println("Counts of regions is " + count);
    }

    public void printStateSquare(int square) {
        System.out.println("The states' square is " + square);
    }
}
