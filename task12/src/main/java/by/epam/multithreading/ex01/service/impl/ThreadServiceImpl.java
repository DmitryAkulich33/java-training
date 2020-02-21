package by.epam.multithreading.ex01.service.impl;

import by.epam.multithreading.ex01.dao.exception.StreamNotReadingException;
import by.epam.multithreading.ex01.dao.impl.ReaderDAOImpl;
import by.epam.multithreading.ex01.domain.Matrix;
import by.epam.multithreading.ex01.domain.MyThread;
import by.epam.multithreading.ex01.service.ThreadService;
import by.epam.multithreading.ex01.service.exception.ServiceException;
import by.epam.multithreading.ex01.service.exception.WrongThreadCountException;
import by.epam.multithreading.ex01.service.parser.LineParser;

import java.util.concurrent.locks.ReentrantLock;

public class ThreadServiceImpl implements ThreadService {
    public int returnThreadsCount(String path) throws ServiceException {
        ReaderDAOImpl readerDAO = new ReaderDAOImpl();
        LineParser lineParser = new LineParser();
        int threadCount;
        try {
            threadCount = lineParser.returnThreadCount(readerDAO.readLines(path));
        } catch (WrongThreadCountException | StreamNotReadingException e) {
            throw new ServiceException(e);
        }
        return threadCount;
    }

    public void startThreads(int threadCount, Matrix matrix, ReentrantLock lock) throws ServiceException {
        for(int i = 1; i <= threadCount; i++){
            MyThread myThread = new MyThread(matrix, lock, i);
            myThread.start();
        }
    }
}
