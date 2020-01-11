package by.epam.exercise01.dao.impl;

import by.epam.exercise01.dao.exception.FileReadingException;
import by.epam.exercise01.dao.exception.FileWritingException;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.dao.TextFileDAO;
import by.epam.exercise01.dao.exception.FileCreatingException;
import by.epam.exercise01.dao.exception.FileRenamingException;
import by.epam.exercise01.domain.TextFile;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class TextFileDAOImpl implements TextFileDAO {

    @Override
    public File create(Directory directory, String fileName, String type) throws FileCreatingException {
        String path = directory.getPath() + "\\" + fileName + "." + type;
        File file = new File(path);
        try {
            if (file.createNewFile()) {
                return file;
            } else {
                throw new FileCreatingException("Problem with creating file.");
            }
        } catch (IOException e) {
            throw new FileCreatingException("Problem with creating file.");
        }
    }

    @Override
    public File rename(Directory directory, String fileName, String type, String newFileName, String newType) throws FileRenamingException {
        String path = directory.getPath() + "\\" + fileName + "." + type;
        String newPath = directory.getPath() + "\\" + newFileName + "." + newType;
        File file = new File(path);
        File newFile = new File(newPath);
        if (file.renameTo(newFile)) {
            return newFile;
        } else {
            throw new FileRenamingException("Problem with renaming file.");
        }
    }

    public void writeContent(Directory directory, String fileName, String type, List<String> content) throws FileWritingException {
        String path = directory.getPath() + "\\" + fileName + "." + type;
        Path source = Paths.get(path);
        try {
            Files.write(source, content, StandardCharsets.UTF_8, StandardOpenOption.WRITE);
        } catch (IOException e) {
            throw new FileWritingException("File writing problems", e);
        }
    }

    public void addWrittenContent(Directory directory, String fileName, String type, List<String> content) throws FileWritingException {
        String path = directory.getPath() + "\\" + fileName + "." + type;
        Path source = Paths.get(path);
        try {
            Files.write(source, content, StandardCharsets.UTF_8, StandardOpenOption.WRITE, StandardOpenOption.APPEND);
        } catch (IOException e) {
            throw new FileWritingException("File writing problems", e);
        }
    }

    public List<String> returnFileContent(Directory directory, String fileName, String type) throws FileReadingException {
        List<String> content;
        String path = directory.getPath() + "\\" + fileName + "." + type;
        Path source = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(source)) {
            content = lineStream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileReadingException("File reading problems");
        }
        return content;
    }
}
