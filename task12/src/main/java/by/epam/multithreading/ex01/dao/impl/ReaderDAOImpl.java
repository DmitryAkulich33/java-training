package by.epam.multithreading.ex01.dao.impl;

import by.epam.multithreading.ex01.dao.exception.StreamNotReadingException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReaderDAOImpl {
    public List<String> readLines(String path) throws StreamNotReadingException {
        List<String> lines;
        Path source = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(source)) {
            lines = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new StreamNotReadingException("File reading problems", e);
        }
        return lines;
    }
}
