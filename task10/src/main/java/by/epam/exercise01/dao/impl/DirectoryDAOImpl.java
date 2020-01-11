package by.epam.exercise01.dao.impl;

import by.epam.exercise01.dao.DirectoryDAO;
import by.epam.exercise01.dao.exception.EmptyDirectoryException;
import by.epam.exercise01.dao.exception.FileCreatingException;
import by.epam.exercise01.dao.exception.FileDeletingException;
import by.epam.exercise01.domain.Directory;

import java.io.File;
import java.util.Arrays;
import java.util.List;

public class DirectoryDAOImpl implements DirectoryDAO {
    @Override
    public File create(String path) throws FileCreatingException {
        File file = new File(path);
        if (file.mkdir()) {
            return file;
        } else {
            throw new FileCreatingException("Problem with creating file.");
        }
    }

    public List<String> findFileList(Directory directory) throws EmptyDirectoryException {
        File folder = new File(directory.getPath());
        List<String> fileList = Arrays.asList(folder.list());
        if (fileList.isEmpty()) {
            throw new EmptyDirectoryException("Directory is empty.");
        }
        return fileList;
    }

    public void deleteFile(Directory directory, String fileName, String type) throws FileDeletingException {
        String path = directory.getPath() + "\\" + fileName + "." + type;
        File file = new File(path);
        if (!file.delete()) {
            throw new FileDeletingException("File is not deleted.");
        }
    }
}
