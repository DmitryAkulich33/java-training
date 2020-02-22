package by.epam.multithreading.method01.service;

import by.epam.multithreading.method01.domain.Matrix;
import by.epam.multithreading.method01.service.exception.ServiceException;

import java.util.concurrent.locks.ReentrantLock;

public interface ThreadService {
    int returnThreadsCount(String path) throws ServiceException;

    void startThreads(int threadCount, Matrix matrix, ReentrantLock lock) throws ServiceException;
}
