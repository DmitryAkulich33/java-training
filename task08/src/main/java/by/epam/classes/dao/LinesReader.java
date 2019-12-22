package by.epam.classes.dao;

import by.epam.classes.dao.exception.StreamNotReadingException;
import by.epam.classes.service.ListValidator;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LinesReader {

    public List<String> returnListCarsFromFile(String path) {
        List<String> cars = new ArrayList<>();
        Path source = Paths.get(path);
        ListValidator validator = new ListValidator();
        try (Stream<String> lineStream = Files.lines(source)) {
            List<String> tempList = lineStream.collect(Collectors.toList());
            if(validator.isLineValid(tempList)) {
                cars = tempList;
            }
        } catch (IOException e){
            throw new StreamNotReadingException("File reading problems", e);
        }
        return cars;
    }
}
