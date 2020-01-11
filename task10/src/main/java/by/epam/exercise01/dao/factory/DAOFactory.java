package by.epam.exercise01.dao.factory;

import by.epam.exercise01.dao.DirectoryDAO;
import by.epam.exercise01.dao.TextFileDAO;
import by.epam.exercise01.dao.impl.DirectoryDAOImpl;
import by.epam.exercise01.dao.impl.TextFileDAOImpl;

public final class DAOFactory {
    private static final DAOFactory instance = new DAOFactory();

    private final TextFileDAO textFileDAOImpl = new TextFileDAOImpl();
    private final DirectoryDAO directoryDAOImpl = new DirectoryDAOImpl();

    private DAOFactory() {
    }

    public static DAOFactory getInstance() {
        return instance;
    }

    public TextFileDAO getTextFileDAOImpl() {
        return textFileDAOImpl;
    }

    public DirectoryDAO getDirectoryDAOImpl() {
        return directoryDAOImpl;
    }
}
