package by.epam.exercise01.service;

import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.service.exception.FilesSearchingException;

public interface DirectoryService {
    Directory createDirectory(String path) throws FilesSearchingException;

    void addFileList(Directory directory) throws FilesSearchingException;

    void deleteFile(Directory directory, String fileName, String type) throws FilesSearchingException;
}
