package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.OrderDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Order;
import by.epam.bakery.domain.StatusEnum;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    private static final String SAVE_ORDER = "INSERT INTO `order` (user_id, total, productionDate, deliveryDate, status)" +
            " VALUES(?, ?, ?, ?, ?)";

    public OrderDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    public List<Order> findByUserId(int userId) throws DaoException {
        return null;
    }

    @Override
    public List<Order> findByStatus(StatusEnum statusEnum) throws DaoException {
        return null;
    }

    @Override
    public void changeStatus(int orderId) throws DaoException {

    }

    @Override
    protected String getTableName() {
        return null;
    }

    @Override
    protected String getIdName() {
        return null;
    }

    @Override
    public void save(Object... parameters) throws DaoException {
        executeUpdate(SAVE_ORDER, parameters);
    }
}
