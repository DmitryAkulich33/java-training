package by.epam.multithreading.method03.service.factory;

import by.epam.multithreading.method03.service.MatrixService;
import by.epam.multithreading.method03.service.ThreadService;
import by.epam.multithreading.method03.service.impl.MatrixServiceImpl;
import by.epam.multithreading.method03.service.impl.ThreadServiceImpl;

public class ServiceFactory {
    private volatile static ServiceFactory instance;

    private final MatrixService matrixService = new MatrixServiceImpl();
    private final ThreadService threadService = new ThreadServiceImpl();

    private ServiceFactory() {
    }

    public static ServiceFactory getInstance() {
        if (instance == null) {
            synchronized (ServiceFactory.class) {
                if (instance == null) {
                    instance = new ServiceFactory();
                }
            }
        }
        return instance;
    }

    public MatrixService getMatrixService() {
        return matrixService;
    }

    public ThreadService getThreadService() {
        return threadService;
    }
}
