package by.epam.exercise04.dao;

import by.epam.exercise04.dao.exception.StreamNotWritingException;
import by.epam.exercise04.domain.DragonCave;

public interface TreasureWriterDAO {
    void writeTreasureInFile(DragonCave dragonCave, String path) throws StreamNotWritingException;
}
