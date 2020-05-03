package by.epam.bakery.service.api;

import by.epam.bakery.domain.Basket;
import by.epam.bakery.service.exception.ServiceException;

public interface BasketService {
    Basket findBasketByUserLogin (String userLogin) throws ServiceException;

}
