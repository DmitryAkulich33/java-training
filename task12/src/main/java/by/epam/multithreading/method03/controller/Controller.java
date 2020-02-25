package by.epam.multithreading.method03.controller;

import by.epam.multithreading.method03.domain.Matrix;
import by.epam.multithreading.method03.service.exception.ServiceException;
import by.epam.multithreading.method03.service.factory.ServiceFactory;
import by.epam.multithreading.method03.view.Viewer;


public class Controller {
    public void execute(String path) {
        Viewer viewer = new Viewer();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Matrix matrix = null;
        try {
            matrix = serviceFactory.getMatrixService().createMatrix(path);
        } catch (ServiceException e) {
            viewer.printResponse(e.getMessage());
        }
        int threadCount = 0;
        try {
            threadCount = serviceFactory.getThreadService().returnThreadsCount(path);
        } catch (ServiceException e) {
            viewer.printResponse(e.getMessage());
        }
        try {
            serviceFactory.getThreadService().startThreads(threadCount, matrix);
        } catch (ServiceException e) {
            viewer.printResponse(e.getMessage());
        }
    }
}
