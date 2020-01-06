package by.epam.exercise04.dao;

import by.epam.exercise04.dao.exception.StreamNotWritingException;
import by.epam.exercise04.domain.Bank;

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

public class LinesWriter {
    public void writeBankInformationInFile(Bank bank, String path) throws StreamNotWritingException {
        Path source = Paths.get(path);
        List<String> list = Stream.of(bank).map(Objects::toString).collect(Collectors.toList());
        try {
            Files.write(source, list, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new StreamNotWritingException("File writing problems", e);
        }
    }
}
