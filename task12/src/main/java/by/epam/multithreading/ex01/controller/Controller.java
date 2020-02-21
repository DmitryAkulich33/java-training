package by.epam.multithreading.ex01.controller;

import by.epam.multithreading.ex01.domain.Matrix;
import by.epam.multithreading.ex01.service.exception.ServiceException;
import by.epam.multithreading.ex01.service.factory.ServiceFactory;

import java.util.concurrent.locks.ReentrantLock;

public class Controller {
    public String execute(String path){
        ReentrantLock locker = new ReentrantLock();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();
        String response;
        Matrix matrix;
        try {
            matrix = serviceFactory.getMatrixService().createMatrix(locker, path);
        } catch (ServiceException e) {
            return e.getMessage();
        }
        int threadCount;
        try {
            threadCount = serviceFactory.getThreadService().returnThreadsCount(path);
        } catch (ServiceException e) {
            return e.getMessage();
        }
        try {
            serviceFactory.getThreadService().startThreads(threadCount, matrix, locker);
            response = "Elements changed successfully";
        } catch (ServiceException e) {
            return e.getMessage();
        }
        return response;
    }
}
