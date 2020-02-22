package by.epam.multithreading.method01.service;

import by.epam.multithreading.method01.domain.Matrix;
import by.epam.multithreading.method01.service.exception.ServiceException;

import java.util.concurrent.locks.ReentrantLock;

public interface MatrixService {
    Matrix createMatrix(ReentrantLock locker, String path) throws ServiceException;
}
