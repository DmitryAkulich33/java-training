package by.epam.bakery.service.api;

import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderService {
    void deleteOrderById(int orderId) throws ServiceException;

    void changeProductionDate(String newDate, int orderId) throws ServiceException, ValidatorException;

    void changeDeliveryDate(String newDate, int orderId) throws ServiceException, ValidatorException;

    void changeStatus(String newStatus, int orderId) throws ServiceException, ValidatorException;

    int findOrderPageAmount(int pageAmount) throws ServiceException;

    int findOrderByUserIdPageAmount(int pageAmount, int userId) throws ServiceException;

    int findOrdersAmount() throws ServiceException;

    int findOrdersCost() throws ServiceException;

    void saveOrder(int userId, double total, LocalDateTime productionDate, LocalDateTime deliveryDate, String status,
                   List<BasketProduct> basketProducts, String userLogin, double newTotal) throws ServiceException;
}
