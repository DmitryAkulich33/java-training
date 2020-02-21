package by.epam.multithreading.ex01.service.impl;

import by.epam.multithreading.ex01.dao.exception.StreamNotReadingException;
import by.epam.multithreading.ex01.dao.impl.ReaderDAOImpl;
import by.epam.multithreading.ex01.domain.Element;
import by.epam.multithreading.ex01.domain.Matrix;
import by.epam.multithreading.ex01.service.MatrixService;
import by.epam.multithreading.ex01.service.exception.ServiceException;
import by.epam.multithreading.ex01.service.exception.WrongArrayException;
import by.epam.multithreading.ex01.service.parser.LineParser;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class MatrixServiceImpl implements MatrixService {

    public Matrix createMatrix(ReentrantLock locker, String path) throws ServiceException {
        ReaderDAOImpl readerDAO = new ReaderDAOImpl();
        LineParser lineParser = new LineParser();
        int[][] array;
        try {
            array = lineParser.returnTwoDimArray(readerDAO.readLines(path));
        } catch (WrongArrayException | StreamNotReadingException e) {
            throw new ServiceException(e);
        }
        return new Matrix(array, getListElement(locker, array), locker);
    }

    private List<Element> getListElement(ReentrantLock locker, int[][] matrix){
        List<Element> elements = new ArrayList<>();
        for (int i = 0; i < matrix.length ; i++) {
            elements.add(new Element(locker, matrix[i][i], i, i));
        }
        return elements;
    }
}
