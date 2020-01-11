package by.epam.exercise01.service;

import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.service.exception.FilesSearchingException;

import java.util.List;

public interface EpamFileService {
    void createFile(Directory directory, String fileName, String type) throws FilesSearchingException;

    void renameFile(Directory directory, String fileName, String type, String newFileName, String newType) throws FilesSearchingException;

    void addContent(Directory directory, String fileName, String type, List<String> content) throws FilesSearchingException;

    void addWrittenContent(Directory directory, String fileName, String type, List<String> content) throws FilesSearchingException;

    List<String> getContent(Directory directory, String fileName, String type) throws FilesSearchingException;
}
