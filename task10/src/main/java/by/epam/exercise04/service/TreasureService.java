package by.epam.exercise04.service;

import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.domain.Treasure;
import by.epam.exercise04.service.exception.EmptyListException;
import by.epam.exercise04.service.exception.ServiceException;
import by.epam.exercise04.service.exception.WrongNumberException;

import java.util.List;

public interface TreasureService {
    Treasure getTheMostExpensiveTreasure(DragonCave dragonCave);
    List<Treasure> selectTreasure(DragonCave dragonCave, int necessarySum) throws WrongNumberException;
    void deleteOneTreasure(Treasure delTreasure, DragonCave dragonCave);
    void deleteTreasures(List<Treasure> delTreasures, DragonCave dragonCave) throws EmptyListException;
}
