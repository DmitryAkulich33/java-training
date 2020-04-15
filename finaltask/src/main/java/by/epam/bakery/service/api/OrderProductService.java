package by.epam.bakery.service.api;

import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public interface OrderProductService {
    void save(int orderId, int pieId) throws ServiceException;
    List<OrderProduct> findByUserId(int userId) throws ServiceException;
    List<OrderProduct> findOrderProducts() throws ServiceException;
    List<OrderProduct> findByOrderId(int orderId) throws ServiceException;
    void deleteOrderProductById(int orderProductId) throws ServiceException;
    OrderProduct findOrderProductById (int orderProductId) throws ServiceException;
    List<OrderProduct> findLimitOrderProduct(int start, int amount) throws ServiceException;
}
