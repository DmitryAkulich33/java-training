package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.OrderProduct;

import java.util.List;

public interface OrderProductDao extends Dao<OrderProduct> {
    List<OrderProduct> findByUserId(int userId) throws DaoException;
    List<OrderProduct> findOrderProducts() throws DaoException;
    List<OrderProduct> findByOrderId(int orderId) throws DaoException;
    OrderProduct findOrderProductById(int orderProductId) throws DaoException;
    List<OrderProduct> findLimitOrderProduct(int start, int amount) throws DaoException;
    List<OrderProduct> findLimitOrderProductByUserId(int userId, int start, int amount) throws DaoException;
}
