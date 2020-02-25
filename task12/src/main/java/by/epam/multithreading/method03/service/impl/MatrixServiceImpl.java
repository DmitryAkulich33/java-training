package by.epam.multithreading.method03.service.impl;

import by.epam.multithreading.method03.dao.ReaderDAO;
import by.epam.multithreading.method03.dao.exception.StreamNotReadingException;
import by.epam.multithreading.method03.dao.impl.ReaderDAOImpl;
import by.epam.multithreading.method03.domain.Matrix;
import by.epam.multithreading.method03.service.MatrixService;
import by.epam.multithreading.method03.service.exception.ServiceException;
import by.epam.multithreading.method03.service.exception.WrongArrayException;
import by.epam.multithreading.method03.service.parser.LineParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.atomic.AtomicInteger;

public class MatrixServiceImpl implements MatrixService {
    private static Logger log = LogManager.getLogger(MatrixServiceImpl.class.getName());

    public Matrix createMatrix(String path) throws ServiceException {

        ReaderDAO readerDAO = new ReaderDAOImpl();
        LineParser lineParser = new LineParser();
        AtomicInteger[][] array;
        try {
            array = lineParser.returnTwoDimArray(readerDAO.readLines(path));
        } catch (WrongArrayException | StreamNotReadingException e) {
            throw new ServiceException(e);
        }
        log.info("Matrix created successfully.");
        return new Matrix(array);
    }
}
