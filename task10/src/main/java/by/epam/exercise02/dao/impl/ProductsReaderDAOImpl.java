package by.epam.exercise02.dao.impl;

import by.epam.exercise02.dao.ProductsReaderDAO;
import by.epam.exercise02.dao.exception.StreamNotReadingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductsReaderDAOImpl implements ProductsReaderDAO {
    public List<String> createListForSaleFromFile(String path) throws StreamNotReadingException {
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

