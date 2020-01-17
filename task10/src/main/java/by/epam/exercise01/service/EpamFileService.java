package by.epam.exercise01.service;

import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.service.exception.ServiceException;

import java.util.List;

public interface EpamFileService {
    void createFile(Directory directory, String fileName, String type) throws ServiceException;

    void renameFile(Directory directory, String fileName, String type, String newFileName, String newType) throws ServiceException;

    void addContent(Directory directory, String fileName, String type, List<String> content) throws ServiceException;

    void addWrittenContent(Directory directory, String fileName, String type, List<String> content) throws ServiceException;

    List<String> getContent(Directory directory, String fileName, String type) throws ServiceException;
}
