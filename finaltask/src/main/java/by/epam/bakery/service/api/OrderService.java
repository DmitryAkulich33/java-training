package by.epam.bakery.service.api;

import by.epam.bakery.domain.Order;
import by.epam.bakery.domain.StatusEnum;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    void save(int userId, double total, LocalDateTime productionDate, LocalDateTime deliveryDate,  String status) throws ServiceException;
    Order findLastOrderByUserId(int userId) throws ServiceException;
    void deleteOrderById(int orderId) throws ServiceException;
    void changeProductionDate(LocalDateTime newDate, int orderId) throws ServiceException;
    void changeDeliveryDate(LocalDateTime newDate, int orderId) throws ServiceException;
    void changeStatus(String newStatus, int orderId) throws ServiceException, ValidatorException;
    void changeTotal(double newTotal, int orderId) throws ServiceException;
    int findOrderPageAmount (int pageAmount) throws ServiceException;
    int findOrderByUserIdPageAmount (int pageAmount, int userId) throws ServiceException;
}
