package by.epam.classes.dao;

import by.epam.classes.dao.exception.StreamNotReadingException;
import by.epam.classes.domain.Car;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class LinesWriter {

    public void writeListCarsInFile(List<Car> cars, String path) {
        Path source = Paths.get(path);
        List<String> list = cars.stream().map(Objects::toString).collect(Collectors.toList());
        try {
            Files.write(source, list, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new StreamNotReadingException("File writing problems", e);
        }
    }
}
