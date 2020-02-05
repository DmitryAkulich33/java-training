package by.epam.composite.dao.factory;

import by.epam.composite.dao.FileReaderDAO;
import by.epam.composite.dao.FileWriterDAO;
import by.epam.composite.dao.impl.FileReaderDAOImpl;
import by.epam.composite.dao.impl.FileWriterDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final FileReaderDAO readerDAO = new FileReaderDAOImpl();
    private final FileWriterDAO writerDAO = new FileWriterDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public FileReaderDAO getReaderDAO() {
        return readerDAO;
    }

    public FileWriterDAO getWriterDAO() {
        return writerDAO;
    }
}
