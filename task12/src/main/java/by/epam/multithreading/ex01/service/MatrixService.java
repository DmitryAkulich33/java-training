package by.epam.multithreading.ex01.service;

import by.epam.multithreading.ex01.domain.Matrix;
import by.epam.multithreading.ex01.service.exception.ServiceException;

import java.util.concurrent.locks.ReentrantLock;

public interface MatrixService {
    Matrix createMatrix(ReentrantLock locker, String path) throws ServiceException;
}
