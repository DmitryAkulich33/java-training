package by.epam.bakery.service.api;

import by.epam.bakery.domain.StatusEnum;
import by.epam.bakery.service.exception.ServiceException;

import java.time.LocalDateTime;

public interface OrderService {
    void save(int userId, double total, LocalDateTime productionDate, LocalDateTime deliveryDate, String status) throws ServiceException;
}
