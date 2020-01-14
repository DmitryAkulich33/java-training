package by.epam.exercise04.dao.impl;

import by.epam.exercise04.dao.TreasureReaderDAO;
import by.epam.exercise04.dao.exception.StreamNotReadingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreasureReaderDAOImpl implements TreasureReaderDAO {
    public List<String> readTreasureList(String path) throws StreamNotReadingException {
        List<String> productsForSale;
        Path source = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(source)) {
            productsForSale = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new StreamNotReadingException("File reading problems");
        }
        return productsForSale;
    }
}
