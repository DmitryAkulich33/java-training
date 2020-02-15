package by.epam.composite.dao.impl;

import by.epam.composite.dao.FileReaderDAO;
import by.epam.composite.dao.exception.FileNotReadingException;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FileReaderDAOImpl implements FileReaderDAO {
    private static Logger log = LogManager.getLogger(FileReaderDAOImpl.class.getName());

    public String read(String path) throws FileNotReadingException {
        String readString;
        try {
            log.info("Reading file...");
            readString = new String(Files.readAllBytes(Paths.get(path)), StandardCharsets.UTF_8);
        } catch (IOException e) {
            log.error("File was not read");
            throw new FileNotReadingException("File reading problems", e);
        }
        log.info("Text from file read successfully.");
        return readString;
    }



}
