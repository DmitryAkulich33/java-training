package by.epam.multithreading.method02.service.impl;

import by.epam.multithreading.method02.dao.ReaderDAO;
import by.epam.multithreading.method02.dao.exception.StreamNotReadingException;
import by.epam.multithreading.method02.dao.impl.ReaderDAOImpl;
import by.epam.multithreading.method02.domain.Matrix;
import by.epam.multithreading.method02.domain.MyThread;
import by.epam.multithreading.method02.service.ThreadService;
import by.epam.multithreading.method02.service.exception.ServiceException;
import by.epam.multithreading.method02.service.exception.WrongThreadCountException;
import by.epam.multithreading.method02.service.parser.LineParser;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class ThreadServiceImpl implements ThreadService {
    private static Logger log = LogManager.getLogger(ThreadServiceImpl.class.getName());

    public int returnThreadsCount(String path) throws ServiceException {
        ReaderDAO readerDAO = new ReaderDAOImpl();
        LineParser lineParser = new LineParser();
        int threadCount;
        try {
            threadCount = lineParser.returnThreadCount(readerDAO.readLines(path));
        } catch (WrongThreadCountException | StreamNotReadingException e) {
            throw new ServiceException(e);
        }
        log.info("Count of thread successfully read.");
        return threadCount;
    }

    public void startThreads(int threadCount, Matrix matrix, Semaphore sem) throws ServiceException {
        for (int i = 1; i <= threadCount; i++) {
            MyThread myThread = new MyThread(matrix, sem, i);
            myThread.start();
            log.info("Thread " + i + " started.");
        }
    }
}
