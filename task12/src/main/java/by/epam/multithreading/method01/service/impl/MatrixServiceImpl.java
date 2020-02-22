package by.epam.multithreading.method01.service.impl;

import by.epam.multithreading.method01.dao.ReaderDAO;
import by.epam.multithreading.method01.dao.exception.StreamNotReadingException;
import by.epam.multithreading.method01.dao.impl.ReaderDAOImpl;
import by.epam.multithreading.method01.domain.Element;
import by.epam.multithreading.method01.domain.Matrix;
import by.epam.multithreading.method01.service.MatrixService;
import by.epam.multithreading.method01.service.exception.ServiceException;
import by.epam.multithreading.method01.service.exception.WrongArrayException;
import by.epam.multithreading.method01.service.parser.LineParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixServiceImpl implements MatrixService {
    private static Logger log = LogManager.getLogger(MatrixServiceImpl.class.getName());

    public Matrix createMatrix(ReentrantLock locker, String path) throws ServiceException {

        ReaderDAO readerDAO = new ReaderDAOImpl();
        LineParser lineParser = new LineParser();
        int[][] array;
        try {
            array = lineParser.returnTwoDimArray(readerDAO.readLines(path));
        } catch (WrongArrayException | StreamNotReadingException e) {
            throw new ServiceException(e);
        }
        log.info("Matrix created successfully.");
        return new Matrix(array, getListElement(locker, array), locker);
    }

    private List<Element> getListElement(ReentrantLock locker, int[][] matrix) {
        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            elements.add(new Element(locker, matrix[i][i], i, i));
        }
        return elements;
    }
}
