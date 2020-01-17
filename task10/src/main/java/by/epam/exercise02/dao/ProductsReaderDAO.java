package by.epam.exercise02.dao;

import by.epam.exercise02.dao.exception.StreamNotReadingException;

import java.util.List;

public interface ProductsReaderDAO {
    List<String> createListForSaleFromFile(String path) throws StreamNotReadingException;
}
