package by.epam.exercise04.dao.factory;

import by.epam.exercise04.dao.TreasureReaderDAO;
import by.epam.exercise04.dao.TreasureWriterDAO;
import by.epam.exercise04.dao.impl.TreasureReaderDAOImpl;
import by.epam.exercise04.dao.impl.TreasureWriterDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final TreasureReaderDAO readerDAO = new TreasureReaderDAOImpl();
    private final TreasureWriterDAO writerDAO = new TreasureWriterDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public TreasureReaderDAO getReaderDAO() {
        return readerDAO;
    }

    public TreasureWriterDAO getWriterDAO() {
        return writerDAO;
    }
}
