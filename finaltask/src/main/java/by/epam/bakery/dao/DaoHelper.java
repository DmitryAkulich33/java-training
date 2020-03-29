package by.epam.bakery.dao;

import by.epam.bakery.dao.connection.ConnectionPool;
import by.epam.bakery.dao.connection.ProxyConnection;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.impl.*;

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

    public BasketDaoImpl createBasketDao() {
        return new BasketDaoImpl(connection);
    }

    public BasketProductDaoImpl createBasketProductDao() {
        return new BasketProductDaoImpl(connection);
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
