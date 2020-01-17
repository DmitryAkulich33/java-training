package by.epam.exercise01.service;

import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.service.exception.ServiceException;

public interface DirectoryService {
    Directory createDirectory(String path) throws ServiceException;

    void addFileList(Directory directory) throws ServiceException;

    void deleteFile(Directory directory, String fileName, String type) throws ServiceException;
}
