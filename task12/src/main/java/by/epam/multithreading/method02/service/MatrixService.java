package by.epam.multithreading.method02.service;

import by.epam.multithreading.method02.domain.Matrix;
import by.epam.multithreading.method02.service.exception.ServiceException;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public interface MatrixService {
    Matrix createMatrix(Semaphore sem, String path) throws ServiceException;
}
