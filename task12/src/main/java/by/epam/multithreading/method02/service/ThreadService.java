package by.epam.multithreading.method02.service;

import by.epam.multithreading.method02.domain.Matrix;
import by.epam.multithreading.method02.service.exception.ServiceException;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public interface ThreadService {
    int returnThreadsCount(String path) throws ServiceException;

    void startThreads(int threadCount, Matrix matrix, Semaphore sem) throws ServiceException;
}
