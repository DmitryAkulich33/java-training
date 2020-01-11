package by.epam.exercise01.service;

import by.epam.exercise01.dao.exception.EmptyDirectoryException;
import by.epam.exercise01.dao.exception.FileCreatingException;
import by.epam.exercise01.dao.impl.DirectoryDAOImpl;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.domain.EpamFile;
import by.epam.exercise01.domain.TextFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class DirectoryService {
    private DirectoryDAOImpl directoryDAO = new DirectoryDAOImpl();

    public Directory createDirectory(String path) throws FileCreatingException {
        return fileFactory(directoryDAO.create(path));
    }

    public void addFileList(Directory directory) throws EmptyDirectoryException {
        List<String> fileList = directoryDAO.findFileList(directory);
        List<EpamFile> epamFileList = new ArrayList<>();
        for (String line : fileList) {
            epamFileList.add(new TextFile(line, directory.getPath() + "\\" + line, findType(line)));
        }
        directory.setFileList(epamFileList);
    }

    public void deleteFile(Directory directory, String name){
        List<EpamFile> fileList = directory.getFileList();
        int size = fileList.size();
        for(int i = 0; i < size; i++){
            if(fileList.get(i).getName().equals(name)){
                fileList.remove(fileList.get(i));
            }
        }
        directoryDAO.deleteFile(directory, name);
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
