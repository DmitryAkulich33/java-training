package by.epam.bakery.service.api;

import by.epam.bakery.domain.Order;
import by.epam.bakery.domain.StatusEnum;
import by.epam.bakery.service.exception.ServiceException;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    void save(int userId, double total, LocalDateTime productionDate, LocalDateTime deliveryDate,  String status) throws ServiceException;
    Order findLastOrderByUserId(int userId) throws ServiceException;
    List<Order> findAllOrders() throws ServiceException;
    List<Order> findOrderByUserId(int userId) throws ServiceException;
    void deleteOrderById(int orderId) throws ServiceException;
    List<Order> findNecessaryOrderAmount(int amount) throws ServiceException;
}
