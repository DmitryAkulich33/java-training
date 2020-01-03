package by.epam.exercise03.dao;

import by.epam.exercise03.dao.exception.StreamNotReadingException;
import by.epam.exercise03.service.ListValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LinesReader {
    public List<String> returnListCitiesFromFile(String path) {
        List<String> cities;
        Path source = Paths.get(path);
        ListValidator validator = new ListValidator();
        try (Stream<String> lineStream = Files.lines(source)) {
            cities = lineStream.filter(validator::isLineValid).collect(Collectors.toList());
        } catch (IOException e) {
            throw new StreamNotReadingException("File reading problems", e);
        }
        return cities;
    }
}
