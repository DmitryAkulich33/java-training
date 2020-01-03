package by.epam.exercise03.dao;

import by.epam.exercise03.dao.exception.StreamNotReadingException;
import by.epam.exercise03.domain.State;

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
    public void writeListRegionsInFile(State state, String path) {
        Path source = Paths.get(path);
        List<String> list = state.getRegions().stream().map(Objects::toString).collect(Collectors.toList());
        try {
            Files.write(source, list, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new StreamNotReadingException("File writing problems", e);
        }
    }

    public void writeListDistrictsInFile(State state, String path) {
        Path source = Paths.get(path);
        List<String> list = state.getDistricts().stream().map(Objects::toString).collect(Collectors.toList());
        try {
            Files.write(source, list, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new StreamNotReadingException("File writing problems", e);
        }
    }

    public void writeListCitiesInFile(State state, String path) {
        Path source = Paths.get(path);
        List<String> list = state.getCities().stream().map(Objects::toString).collect(Collectors.toList());
        try {
            Files.write(source, list, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new StreamNotReadingException("File writing problems", e);
        }
    }
}
