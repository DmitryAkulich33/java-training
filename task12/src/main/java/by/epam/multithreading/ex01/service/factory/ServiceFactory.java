package by.epam.multithreading.ex01.service.factory;

import by.epam.multithreading.ex01.service.MatrixService;
import by.epam.multithreading.ex01.service.ThreadService;
import by.epam.multithreading.ex01.service.impl.MatrixServiceImpl;
import by.epam.multithreading.ex01.service.impl.ThreadServiceImpl;

public final class ServiceFactory {
    private static final ServiceFactory instance = new ServiceFactory();

    private final MatrixService matrixService = new MatrixServiceImpl();
    private final ThreadService threadService = new ThreadServiceImpl();


    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        return instance;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }

    public ThreadService getThreadService() {
        return threadService;
    }
}
