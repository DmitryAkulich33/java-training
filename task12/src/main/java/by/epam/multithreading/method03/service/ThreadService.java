package by.epam.multithreading.method03.service;

import by.epam.multithreading.method03.domain.Matrix;
import by.epam.multithreading.method03.service.exception.ServiceException;


public interface ThreadService {
    int returnThreadsCount(String path) throws ServiceException;

    void startThreads(int threadCount, Matrix matrix) throws ServiceException;
}
