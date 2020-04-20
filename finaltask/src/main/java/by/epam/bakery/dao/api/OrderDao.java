package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Order;
import by.epam.bakery.domain.StatusEnum;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface OrderDao extends Dao<Order> {
    Order findLastUserOrderById(int userId) throws DaoException;
    void changeProductionDate(LocalDateTime newDate, int orderId) throws DaoException;
    void changeDeliveryDate(LocalDateTime newDate, int orderId) throws DaoException;
    void changeStatus(String newStatus, int orderId) throws DaoException;
    void changeTotal(double newTotal, int orderId) throws DaoException;
    int findAmountOrdersByUserId (int userId) throws DaoException;
}
