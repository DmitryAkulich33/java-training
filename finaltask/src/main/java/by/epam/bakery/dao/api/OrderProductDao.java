package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.OrderProduct;

import java.util.List;

public interface OrderProductDao extends Dao<OrderProduct> {
    List<OrderProduct> findByUserId(int userId) throws DaoException;
    void deleteOrderProductByOrderId(int orderId) throws DaoException;
}
