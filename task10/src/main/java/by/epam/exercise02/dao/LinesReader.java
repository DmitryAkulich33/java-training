package by.epam.exercise02.dao;

import by.epam.exercise02.dao.exception.StreamNotReadingException;
import by.epam.exercise02.service.validator.ListValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LinesReader {
    public List<String> createListForSaleFromFile(String path) throws StreamNotReadingException {
        List<String> productsForSale;
        Path source = Paths.get(path);
        ListValidator validator = new ListValidator();
        try (Stream<String> lineStream = Files.lines(source)) {
            productsForSale = lineStream.filter(validator::isLineValid).collect(Collectors.toList());
        } catch (IOException e) {
            throw new StreamNotReadingException("EpamFile reading problems", e);
        }
        return productsForSale;
    }
}

