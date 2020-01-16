package by.epam.exercise04.dao;

import by.epam.exercise04.dao.exception.StreamNotWritingException;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.domain.Treasure;

import java.util.List;

public interface TreasureWriterDAO {
    void writeTreasureInFile(DragonCave dragonCave, String path) throws StreamNotWritingException;
}
