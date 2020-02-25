package by.epam.multithreading.method02.service.impl;

import by.epam.multithreading.method02.dao.ReaderDAO;
import by.epam.multithreading.method02.dao.exception.StreamNotReadingException;
import by.epam.multithreading.method02.dao.impl.ReaderDAOImpl;
import by.epam.multithreading.method02.domain.Element;
import by.epam.multithreading.method02.domain.Matrix;
import by.epam.multithreading.method02.service.MatrixService;
import by.epam.multithreading.method02.service.exception.ServiceException;
import by.epam.multithreading.method02.service.exception.WrongArrayException;
import by.epam.multithreading.method02.service.parser.LineParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixServiceImpl implements MatrixService {
    private static Logger log = LogManager.getLogger(MatrixServiceImpl.class.getName());

    public Matrix createMatrix(Semaphore sem, String path) throws ServiceException {

        ReaderDAO readerDAO = new ReaderDAOImpl();
        LineParser lineParser = new LineParser();
        int[][] array;
        try {
            array = lineParser.returnTwoDimArray(readerDAO.readLines(path));
        } catch (WrongArrayException | StreamNotReadingException e) {
            throw new ServiceException(e);
        }
        log.info("Matrix created successfully.");
        return new Matrix(array, getListElement(sem, array), sem);
    }

    private List<Element> getListElement(Semaphore sem, int[][] matrix) {
        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            elements.add(new Element(sem, matrix[i][i], i, i));
        }
        return elements;
    }
}
