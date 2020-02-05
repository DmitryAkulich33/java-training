package by.epam.composite.dao;

import by.epam.composite.dao.exception.FileNotReadingException;

public interface FileReaderDAO {
    String read(String path) throws FileNotReadingException;
}
