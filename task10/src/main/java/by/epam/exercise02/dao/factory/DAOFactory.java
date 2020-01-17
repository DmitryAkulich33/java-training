package by.epam.exercise02.dao.factory;

import by.epam.exercise02.dao.ProductsReaderDAO;
import by.epam.exercise02.dao.ProductsWriterDAO;
import by.epam.exercise02.dao.impl.ProductsReaderDAOImpl;
import by.epam.exercise02.dao.impl.ProductsWriterDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final ProductsReaderDAO readerDAO = new ProductsReaderDAOImpl();
    private final ProductsWriterDAO writerDAO = new ProductsWriterDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public ProductsReaderDAO getReaderDAO() {
        return readerDAO;
    }

    public ProductsWriterDAO getWriterDAO() {
        return writerDAO;
    }
}
