package by.epam.exercise01.service.factory;

import by.epam.exercise01.service.DirectoryService;
import by.epam.exercise01.service.EpamFileService;
import by.epam.exercise01.service.impl.DirectoryServiceImpl;
import by.epam.exercise01.service.impl.EpamFileServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final DirectoryService directoryService = new DirectoryServiceImpl();
    private final EpamFileService epamFileService = new EpamFileServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public DirectoryService getDirectoryService() {
        return directoryService;
    }

    public EpamFileService getEpamFileService() {
        return epamFileService;
    }
}
