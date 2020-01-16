package by.epam.exercise04.service;

import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.domain.Treasure;

import java.util.List;

public interface TreasureService {
    Treasure getTheMostExpensiveTreasure(DragonCave dragonCave);
    List<Treasure> selectTreasure(DragonCave dragonCave, int necessarySum);
    void deleteOneTreasure(Treasure delTreasure, DragonCave dragonCave);
    void deleteTreasures(List<Treasure> delTreasures, DragonCave dragonCave);
}
