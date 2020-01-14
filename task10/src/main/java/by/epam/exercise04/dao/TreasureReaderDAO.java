package by.epam.exercise04.dao;

import by.epam.exercise04.dao.exception.StreamNotReadingException;

import java.util.List;

public interface TreasureReaderDAO {
    List<String> readTreasureList(String path) throws StreamNotReadingException;
}
