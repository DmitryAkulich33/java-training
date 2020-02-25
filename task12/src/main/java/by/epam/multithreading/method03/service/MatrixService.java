package by.epam.multithreading.method03.service;

import by.epam.multithreading.method03.domain.Matrix;
import by.epam.multithreading.method03.service.exception.ServiceException;


public interface MatrixService {
    Matrix createMatrix(String path) throws ServiceException;
}
