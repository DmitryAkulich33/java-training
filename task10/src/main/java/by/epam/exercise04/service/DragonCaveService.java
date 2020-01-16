package by.epam.exercise04.service;

import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.domain.Treasure;
import by.epam.exercise04.service.exception.EmptyListException;
import by.epam.exercise04.service.exception.ServiceException;

import java.util.List;

public interface DragonCaveService {
    DragonCave createDragonCave(String path) throws ServiceException, EmptyListException;
    List<String> findValidLines(String pathFile) throws ServiceException, EmptyListException;
    List<Treasure> findTreasureList(List<String> lines);
}
