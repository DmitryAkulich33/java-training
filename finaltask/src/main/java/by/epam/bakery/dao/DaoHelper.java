package by.epam.bakery.dao;

import by.epam.bakery.dao.connection.ConnectionPool;
import by.epam.bakery.dao.connection.ProxyConnection;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.impl.FeedbackDaoImpl;
import by.epam.bakery.dao.impl.OrderDaoImpl;
import by.epam.bakery.dao.impl.PieDaoImpl;
import by.epam.bakery.dao.impl.UserDaoImpl;

import java.sql.SQLException;

public class DaoHelper implements AutoCloseable {
    private ProxyConnection connection;

    public DaoHelper(ConnectionPool connectionPool) {
        this.connection = connectionPool.getConnection();
    }

    public UserDaoImpl createUserDao() {
        return new UserDaoImpl(connection);
    }

    public PieDaoImpl createPieDao() {
        return new PieDaoImpl(connection);
    }

    public FeedbackDaoImpl createFeedBackDao() {
        return new FeedbackDaoImpl(connection);
    }

    public OrderDaoImpl createOrderDao() {
        return new OrderDaoImpl(connection);
    }

    @Override
    public void close() throws DaoException {
        try {
            connection.close();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    public void startTransaction() throws DaoException {
        try {
            connection.setAutoCommit(false);
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }
}
