package by.epam.multithreading.method01.dao.impl;

import by.epam.multithreading.method01.dao.ReaderDAO;
import by.epam.multithreading.method01.dao.exception.StreamNotReadingException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderDAOImpl implements ReaderDAO {
    private static Logger log = LogManager.getLogger(ReaderDAOImpl.class.getName());

    public List<String> readLines(String path) throws StreamNotReadingException {
        List<String> lines;
        Path source = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(source)) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            log.error("File was not read");
            throw new StreamNotReadingException("File reading problems", e);
        }
        return lines;
    }
}
