package by.epam.exercise01.controller.command.impl;

import by.epam.exercise01.controller.command.Command;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.service.EpamFileService;
import by.epam.exercise01.service.exception.ServiceException;
import by.epam.exercise01.service.factory.ServiceFactory;
import by.epam.exercise01.view.Viewer;

public class FileCreator implements Command {
    @Override
    public String execute(String request, Directory directory) {
        String response;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Viewer viewer = new Viewer();
        String fileName = viewer.returnFileName();
        String fileType = viewer.returnFileType();
        try {
            serviceFactory.getEpamFileService().createFile(directory, fileName, fileType);
            response = "The file was created successfully";
        } catch (ServiceException ex) {
            response = ex.getMessage();
        }
        return response;
    }
}
