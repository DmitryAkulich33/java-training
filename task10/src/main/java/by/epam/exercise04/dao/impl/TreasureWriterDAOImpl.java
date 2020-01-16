package by.epam.exercise04.dao.impl;

import by.epam.exercise02.domain.Payment;
import by.epam.exercise04.dao.TreasureWriterDAO;
import by.epam.exercise04.dao.exception.StreamNotWritingException;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.domain.Treasure;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TreasureWriterDAOImpl implements TreasureWriterDAO {
    public void writeTreasureInFile1(List<Treasure> treasures, String path) throws StreamNotWritingException {
        Path source = Paths.get(path);
        List<String> list = Stream.of(treasures).map(Objects::toString).collect(Collectors.toList());
        try {
            Files.write(source, list, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new StreamNotWritingException("File writing problems");
        }
    }

    public void writeTreasureInFile(DragonCave dragonCave, String path) throws by.epam.exercise02.dao.exception.StreamNotWritingException {
        Path source = Paths.get(path);
        List<String> list = Stream.of(dragonCave).map(Objects::toString).collect(Collectors.toList());
        try {
            Files.write(source, list, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new StreamNotWritingException("File writing problems");
        }
    }
}
