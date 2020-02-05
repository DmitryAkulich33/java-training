package by.epam.composite.dao;

import by.epam.composite.dao.exception.FileNotWritingException;
import by.epam.composite.domain.Component;

public interface FileWriterDAO {
    void write (Component component, String path) throws FileNotWritingException;
}
