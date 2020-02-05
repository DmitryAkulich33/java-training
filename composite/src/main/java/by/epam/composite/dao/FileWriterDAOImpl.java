package by.epam.composite.dao;

import by.epam.composite.dao.exception.FileNotWritingException;
import by.epam.composite.domain.Component;

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

public class FileWriterDAOImpl {
    public void write (Component component, String path) throws FileNotWritingException{
        Path source = Paths.get(path);
        List<String> list = Stream.of(component).map(Objects::toString).collect(Collectors.toList());
        try {
            Files.write(source, list, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new FileNotWritingException("File writing problems", e);
        }
    }
}
