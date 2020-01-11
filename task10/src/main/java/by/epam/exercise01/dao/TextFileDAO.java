package by.epam.exercise01.dao;

import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.domain.EpamFile;
import by.epam.exercise01.domain.TextFile;

import java.io.File;
import java.util.List;

public interface TextFileDAO {
    File create(Directory directory, String fileName, String type);
    File rename(Directory directory, String fileName, String type, String newFileName, String newType);
    void writeContent(TextFile textFile, List<String> content);
    void addWrittenContent(TextFile textFile, List<String> content);
}
