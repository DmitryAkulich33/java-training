package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Order;
import by.epam.bakery.domain.StatusEnum;

import java.util.List;
import java.util.Optional;

public interface OrderDao extends Dao<Order> {
    List<Order> findByUserId(int userId) throws DaoException;
    List<Order> findByStatus(StatusEnum statusEnum) throws DaoException;
    void changeStatus (int orderId) throws DaoException;
    Order findLastUserOrderById(int userId) throws DaoException;
}
