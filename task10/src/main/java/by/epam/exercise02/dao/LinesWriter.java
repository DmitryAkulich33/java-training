package by.epam.exercise02.dao;

import by.epam.exercise02.dao.exception.StreamNotWritingException;
import by.epam.exercise02.domain.Payment;

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
    public void writeListToBuyInFile(Payment payment, String path) throws StreamNotWritingException {
        Path source = Paths.get(path);
        List<String> list = Stream.of(payment).map(Objects::toString).collect(Collectors.toList());
        try {
            Files.write(source, list, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new StreamNotWritingException("File writing problems", e);
        }
    }
}
