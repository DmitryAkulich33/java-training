package by.epam.multithreading.method01.controller;

import by.epam.multithreading.method01.domain.Matrix;
import by.epam.multithreading.method01.service.exception.ServiceException;
import by.epam.multithreading.method01.service.factory.ServiceFactory;
import by.epam.multithreading.method01.view.Viewer;

import java.util.concurrent.locks.ReentrantLock;

public class Controller {
    public void execute(String path) {
        ReentrantLock locker = new ReentrantLock();
        Viewer viewer = new Viewer();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Matrix matrix = null;
        try {
            matrix = serviceFactory.getMatrixService().createMatrix(locker, path);
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
            serviceFactory.getThreadService().startThreads(threadCount, matrix, locker);
        } catch (ServiceException e) {
            viewer.printResponse(e.getMessage());
        }
    }
}
