package by.epam.exercise01.controller;

import by.epam.exercise01.controller.command.Command;
import by.epam.exercise01.domain.Directory;
import by.epam.exercise01.service.DirectoryService;
import by.epam.exercise01.service.exception.FilesSearchingException;
import by.epam.exercise01.service.factory.ServiceFactory;

public final class Controller {
    private CommandProvider commandProvider = new CommandProvider();

    public String executeTask(String request, Directory directory) {
        Command executionCommand = commandProvider.getCommand(request);
        return executionCommand.execute(request, directory);
    }

    public Directory createDirectory(String path){
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        DirectoryService directoryService = serviceFactory.getDirectoryService();
        Directory directory = null;
        try {
            directory = directoryService.createDirectory(path);
        } catch (FilesSearchingException e) {
            System.out.println(e.getMessage());
        }
        return directory;
    }
}
