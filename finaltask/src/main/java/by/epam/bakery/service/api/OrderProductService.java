package by.epam.bakery.service.api;

import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public interface OrderProductService {
    void save(int orderId, int pieId, int amount, double cost) throws ServiceException;
    List<OrderProduct> findLimitOrderProduct(int start, int amount) throws ServiceException;
    List<OrderProduct> findLimitOrderProductByUserId(int userId, int start, int amount) throws ServiceException;
    void deleteOrderProduct(int orderProductId) throws ServiceException;
}
