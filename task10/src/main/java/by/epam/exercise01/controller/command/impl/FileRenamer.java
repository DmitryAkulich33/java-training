package by.epam.exercise01.controller.command.impl;

import by.epam.exercise01.controller.command.Command;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.service.EpamFileService;
import by.epam.exercise01.service.exception.ServiceException;
import by.epam.exercise01.service.factory.ServiceFactory;
import by.epam.exercise01.view.Viewer;

public class FileRenamer implements Command {
    @Override
    public String execute(String request, Directory directory) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        EpamFileService epamFileService = serviceFactory.getEpamFileService();
        Viewer viewer = new Viewer();
        String fileName = viewer.returnFileName();
        String fileType = viewer.returnFileType();
        String newFileName = viewer.returnNewFileName();
        String newFileType = viewer.returnNewFileType();
        try {
            epamFileService.renameFile(directory, fileName, fileType, newFileName, newFileType);
            response = "The file has been renamed";
        } catch (ServiceException ex) {
            response = ex.getMessage();
        }
        return response;
    }
}
