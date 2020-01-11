package by.epam.exercise01.service.impl;

import by.epam.exercise01.dao.TextFileDAO;
import by.epam.exercise01.dao.exception.FileCreatingException;
import by.epam.exercise01.dao.exception.FileReadingException;
import by.epam.exercise01.dao.exception.FileRenamingException;
import by.epam.exercise01.dao.exception.FileWritingException;
import by.epam.exercise01.dao.factory.DAOFactory;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.domain.EpamFile;
import by.epam.exercise01.domain.TextFile;
import by.epam.exercise01.service.EpamFileService;
import by.epam.exercise01.service.exception.FilesSearchingException;

import java.io.File;
import java.util.List;

public class EpamFileServiceImpl implements EpamFileService {
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private TextFileDAO textFileDAO = daoObjectFactory.getTextFileDAOImpl();

    public void createFile(Directory directory, String fileName, String type) throws FilesSearchingException {
        try {
            fileFactory(textFileDAO.create(directory, fileName, type));
        } catch (FileCreatingException e) {
            throw new FilesSearchingException(e);
        }
    }

    public void renameFile(Directory directory, String fileName, String type, String newFileName, String newType) throws FilesSearchingException {
        try {
            fileFactory(textFileDAO.rename(directory, fileName, type, newFileName, newType));
        } catch (FileRenamingException e) {
            throw new FilesSearchingException(e);
        }
    }

    public void addContent(Directory directory, String fileName, String type, List<String> content) throws FilesSearchingException {
        try {
            textFileDAO.writeContent(directory, fileName, type, content);
        } catch (FileWritingException e) {
            throw new FilesSearchingException(e);
        }
    }

    public void addWrittenContent(Directory directory, String fileName, String type, List<String> content) throws FilesSearchingException {
        try {
            textFileDAO.addWrittenContent(directory, fileName, type, content);
        } catch (FileWritingException e) {
            throw new FilesSearchingException(e);
        }
    }

    public List<String> getContent(Directory directory, String fileName, String type) throws FilesSearchingException {
        List<String> content;
        try {
            content = textFileDAO.returnFileContent(directory, fileName, type);
        } catch (FileReadingException e) {
            throw new FilesSearchingException(e);
        }
        if (content.isEmpty()) {
            throw new FilesSearchingException("File is empty.");
        }
        return content;
    }

    public EpamFile fileFactory(File file) {
        EpamFile epamFile;
        String fileName = file.getName();
        String filePath = file.getPath();
        String fileType = "";
        if (fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            fileType = fileName.substring(fileName.lastIndexOf(".") + 1);

        }
        epamFile = new TextFile(fileName, filePath, fileType);
        return epamFile;
    }
}
