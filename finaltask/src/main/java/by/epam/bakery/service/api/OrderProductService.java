package by.epam.bakery.service.api;

import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public interface OrderProductService {
    void save(int orderId, int pieId) throws ServiceException;
    List<OrderProduct> findByUserId(int userId) throws ServiceException;
    void deleteOrderProductByOrderId(int orderId) throws ServiceException;
    List<OrderProduct> findOrderProducts() throws ServiceException;
    List<OrderProduct> findByOrderId(int orderId) throws ServiceException;
}
