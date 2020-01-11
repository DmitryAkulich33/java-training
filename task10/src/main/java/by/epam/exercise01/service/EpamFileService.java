package by.epam.exercise01.service;

import by.epam.exercise01.dao.exception.FileCreatingException;
import by.epam.exercise01.dao.exception.FileRenamingException;
import by.epam.exercise01.dao.exception.FileWritingException;
import by.epam.exercise01.dao.impl.TextFileDAOImpl;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.domain.EpamFile;
import by.epam.exercise01.domain.TextFile;

import java.io.File;
import java.util.List;

public class EpamFileService {
    private TextFileDAOImpl textFileDAO = new TextFileDAOImpl();

    public EpamFile createFile(Directory directory, String fileName, String type) throws FileCreatingException {
        return fileFactory(textFileDAO.create(directory, fileName, type));
    }

    public EpamFile renameFile(Directory directory, String fileName, String type, String newFileName, String newType) throws FileRenamingException {
        return fileFactory(textFileDAO.rename(directory, fileName, type, newFileName, newType));
    }

    public void addContent (EpamFile epamFile, List<String> content) throws FileWritingException {
        textFileDAO.writeContent((TextFile) epamFile, content);
    }

    public void addWrittenContent (EpamFile epamFile, List<String> content) throws FileWritingException {
        textFileDAO.addWrittenContent((TextFile) epamFile, content);
    }

    public EpamFile fileFactory(File file){
        EpamFile epamFile;
        String fileName = file.getName();
        String filePath = file.getPath();
        String fileType = "";
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0) {
            fileType = fileName.substring(fileName.lastIndexOf(".") + 1);

        }
        epamFile = new TextFile(fileName, filePath, fileType);
        return epamFile;
    }
}
