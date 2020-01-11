package by.epam.exercise01.controller.command.impl;

import by.epam.exercise01.controller.command.Command;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.service.DirectoryService;
import by.epam.exercise01.service.exception.FilesSearchingException;
import by.epam.exercise01.service.factory.ServiceFactory;
import by.epam.exercise01.view.Viewer;


public class FileDeleter implements Command {
    @Override
    public String execute(String request, Directory directory) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        DirectoryService directoryService = serviceFactory.getDirectoryService();
        Viewer viewer = new Viewer();
        String fileName = viewer.returnFileName();
        String fileType = viewer.returnFileType();
        try {
            directoryService.addFileList(directory);
            directoryService.deleteFile(directory, fileName, fileType);
            response = "The file was deleted successfully";
        } catch (FilesSearchingException ex) {
            response = ex.getMessage();
        }
        return response;
    }
}
