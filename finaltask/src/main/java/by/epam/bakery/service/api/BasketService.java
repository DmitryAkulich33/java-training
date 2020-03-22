package by.epam.bakery.service.api;

import by.epam.bakery.domain.Basket;
import by.epam.bakery.service.exception.ServiceException;

public interface BasketService {
    double getTotal(Basket basket) throws ServiceException;
}
