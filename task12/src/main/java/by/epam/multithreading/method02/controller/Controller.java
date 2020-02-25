package by.epam.multithreading.method02.controller;

import by.epam.multithreading.method02.domain.Matrix;
import by.epam.multithreading.method02.service.exception.ServiceException;
import by.epam.multithreading.method02.service.factory.ServiceFactory;
import by.epam.multithreading.method02.view.Viewer;

import java.util.concurrent.Semaphore;

public class Controller {
    public void execute(String path) {
        Semaphore sem = new Semaphore(1);
        Viewer viewer = new Viewer();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        Matrix matrix = null;
        try {
            matrix = serviceFactory.getMatrixService().createMatrix(sem, path);
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
            serviceFactory.getThreadService().startThreads(threadCount, matrix, sem);
        } catch (ServiceException e) {
            viewer.printResponse(e.getMessage());
        }
    }
}
