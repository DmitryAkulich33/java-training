package by.epam.exercise01.controller.command.impl;

import by.epam.exercise01.controller.command.Command;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.service.EpamFileService;
import by.epam.exercise01.service.exception.ServiceException;
import by.epam.exercise01.service.factory.ServiceFactory;
import by.epam.exercise01.view.Viewer;

import java.util.List;

public class FileAdding implements Command {
    @Override
    public String execute(String request, Directory directory) {
        String response = null;
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Viewer viewer = new Viewer();
        String fileName = viewer.returnFileName();
        String fileType = viewer.returnFileType();
        List<String> content = viewer.printTextForFile();
        try {
            serviceFactory.getEpamFileService().addContent(directory, fileName, fileType, content);
            response = "The lines were added successfully";
        } catch (ServiceException ex) {
            response = ex.getMessage();
        }
        return response;
    }
}
