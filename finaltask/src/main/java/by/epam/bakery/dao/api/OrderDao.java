package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Order;

import java.time.LocalDateTime;

public interface OrderDao extends Dao<Order> {
    Order findLastUserOrderById(int userId) throws DaoException;

    void changeProductionDate(LocalDateTime newDate, int orderId) throws DaoException;

    void changeDeliveryDate(LocalDateTime newDate, int orderId) throws DaoException;

    void changeStatus(String newStatus, int orderId) throws DaoException;

    void changeTotal(double newTotal, int orderId) throws DaoException;

    int findAmountOrdersByUserId(int userId) throws DaoException;

    int findOrdersAmount() throws DaoException;

    int findOrdersCost() throws DaoException;
}
