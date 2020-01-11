package by.epam.exercise01.service.impl;

import by.epam.exercise01.dao.DirectoryDAO;
import by.epam.exercise01.dao.exception.EmptyDirectoryException;
import by.epam.exercise01.dao.exception.FileCreatingException;
import by.epam.exercise01.dao.exception.FileDeletingException;
import by.epam.exercise01.dao.factory.DAOFactory;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.domain.EpamFile;
import by.epam.exercise01.domain.TextFile;
import by.epam.exercise01.service.DirectoryService;
import by.epam.exercise01.service.exception.FilesSearchingException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryServiceImpl implements DirectoryService {
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private DirectoryDAO directoryDAO = daoObjectFactory.getDirectoryDAOImpl();

    public Directory createDirectory(String path) throws FilesSearchingException {
        try {
            return fileFactory(directoryDAO.create(path));
        } catch (FileCreatingException e) {
            throw new FilesSearchingException(e);
        }
    }

    public void addFileList(Directory directory) throws FilesSearchingException {
        List<String> fileList = null;
        try {
            fileList = directoryDAO.findFileList(directory);
        } catch (EmptyDirectoryException e) {
            throw new FilesSearchingException(e.getMessage());
        }
        List<EpamFile> epamFileList = new ArrayList<>();
        for (String line : fileList) {
            epamFileList.add(new TextFile(line, directory.getPath() + "\\" + line, findType(line)));
        }
        directory.setFileList(epamFileList);
    }

    public void deleteFile(Directory directory, String fileName, String type) throws FilesSearchingException {
        List<EpamFile> fileList = directory.getFileList();
        int size = fileList.size();
        for (int i = 0; i < size; i++) {
            if (fileList.get(i).getName().equals(fileName + "." + type)) {
                fileList.remove(fileList.get(i));
            }
        }
        try {
            directoryDAO.deleteFile(directory, fileName, type);
        } catch (FileDeletingException e) {
            throw new FilesSearchingException(e);
        }
        directory.setFileList(fileList);
    }

    public String findType(String path) {
        return path.substring(path.lastIndexOf(".") + 1);
    }

    public Directory fileFactory(File file) {
        String fileName = file.getName();
        String filePath = file.getPath();
        return new Directory(fileName, filePath);
    }
}
