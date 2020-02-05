package by.epam.composite.dao.impl;

import by.epam.composite.dao.FileReaderDAO;
import by.epam.composite.dao.exception.FileNotReadingException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderDAOImpl implements FileReaderDAO {

    public String read(String path) throws FileNotReadingException {
        String readString;
        try {
            readString = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            throw new FileNotReadingException("File reading problems", e);
        }
        return readString;
    }



}
