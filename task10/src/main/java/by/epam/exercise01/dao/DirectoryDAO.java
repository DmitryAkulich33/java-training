package by.epam.exercise01.dao;

import by.epam.exercise01.dao.exception.EmptyDirectoryException;
import by.epam.exercise01.dao.exception.FileCreatingException;
import by.epam.exercise01.dao.exception.FileDeletingException;
import by.epam.exercise01.domain.Directory;

import java.io.File;
import java.util.List;

public interface DirectoryDAO {
    File create(String path) throws FileCreatingException;

    List<String> findFileList(Directory directory) throws EmptyDirectoryException;

    void deleteFile(Directory directory, String fileName, String type) throws FileDeletingException;
}
