package by.epam.exercise01.dao;

import by.epam.exercise01.dao.exception.FileCreatingException;
import by.epam.exercise01.dao.exception.FileReadingException;
import by.epam.exercise01.dao.exception.FileRenamingException;
import by.epam.exercise01.dao.exception.FileWritingException;
import by.epam.exercise01.domain.Directory;

import java.io.File;
import java.util.List;

public interface TextFileDAO {
    File create(Directory directory, String fileName, String type) throws FileCreatingException;

    File rename(Directory directory, String fileName, String type, String newFileName, String newType) throws FileRenamingException;

    void writeContent(Directory directory, String fileName, String type, List<String> content) throws FileWritingException;

    void addWrittenContent(Directory directory, String fileName, String type, List<String> content) throws FileWritingException;

    List<String> returnFileContent(Directory directory, String fileName, String type) throws FileReadingException;
}
