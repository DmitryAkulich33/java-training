package by.epam.bakery.service.api;

import by.epam.bakery.service.exception.ServiceException;

public interface OrderProductService {
    void save(int orderId, int pieId) throws ServiceException;
}
