package by.epam.exercise04.dao;

import by.epam.exercise04.dao.exception.StreamNotWritingException;
import by.epam.exercise04.domain.Treasure;

import java.util.List;

public interface TreasureWriterDAO {
    void writeTreasureInFile(List<Treasure> treasures, String path) throws StreamNotWritingException;
}
