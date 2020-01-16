package by.epam.exercise04.controller;

import by.epam.exercise04.domain.Constants;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.domain.Treasure;
import by.epam.exercise04.service.impl.DragonCaveServiceImpl;
import by.epam.exercise04.service.impl.TreasureServiceImpl;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        DragonCaveServiceImpl service = new DragonCaveServiceImpl();
        TreasureServiceImpl treasureService = new TreasureServiceImpl();
        DragonCave dragonCave = service.createDragonCave(Constants.TREASURE_LIST_PATH);

        int i = 1;
        for (Treasure treasure: dragonCave.getTreasures()) {
            System.out.println(i + " " + treasure);
            i++;
        }
        Treasure treasure = treasureService.getTheMostExpensiveTreasure(dragonCave);
        System.out.println(treasure);
        treasureService.deleteOneTreasure(treasure, dragonCave);
        i = 1;
        for (Treasure treasureTest: dragonCave.getTreasures()) {
            System.out.println(i + " " + treasureTest);
            i++;
        }
        System.out.println();
        i = 1;
        List<Treasure> delTreasure = treasureService.selectTreasure(dragonCave, 500);
        for (Treasure treasureTest: delTreasure) {
            System.out.println(i + " " + treasureTest);
            i++;
        }
        System.out.println();
        treasureService.deleteTreasures(delTreasure, dragonCave);
        System.out.println();
        i = 1;
        for (Treasure treasureTest: dragonCave.getTreasures()) {
            System.out.println(i + " " + treasureTest);
            i++;
        }
    }
}
