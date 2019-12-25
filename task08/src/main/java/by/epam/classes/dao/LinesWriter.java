package by.epam.classes.dao;

import by.epam.classes.dao.exception.StreamNotReadingException;
import by.epam.classes.domain.Car;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

import java.util.List;

public class LinesWriter {

    public void writeListCarsInFile(List<Car> cars, String path) {
        Path source = Paths.get(path);
        List<String> list = returnListStringFromObject(cars);
        try {
            Files.write(source, list, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new StreamNotReadingException("File writing problems", e);
        }
    }

    public List<String> returnListStringFromObject(List<Car> cars) {
        List<String> list = new ArrayList<>();
        for (Car line : cars) {
            list.add(line.toString());
        }
        return list;
    }
}
