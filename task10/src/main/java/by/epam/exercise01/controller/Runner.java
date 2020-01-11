package by.epam.exercise01.controller;

import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.service.DirectoryService;
import by.epam.exercise01.service.exception.FilesSearchingException;
import by.epam.exercise01.service.factory.ServiceFactory;
import by.epam.exercise01.view.Viewer;

public class Runner {
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        Controller controller = new Controller();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        DirectoryService directoryService = serviceFactory.getDirectoryService();
        Directory directory = null;
        try {
            directory = directoryService.createDirectory(viewer.printCreatingDirectory());
        } catch (FilesSearchingException e) {
            System.out.println(e.getMessage());
        }
        while (true) {
            String request = viewer.printCommandMenu();
            if (request.equals("0")) {
                return;
            } else {
                viewer.printRequest(controller.executeTask(request, directory));
            }
            viewer.printNewAttempt();
        }
    }
}
