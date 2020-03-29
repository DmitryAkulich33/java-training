package by.epam.bakery.service.api;

import by.epam.bakery.domain.Basket;
import by.epam.bakery.service.exception.ServiceException;

public interface BasketService {
    void saveBasket(String userLogin, double total) throws ServiceException;
    Basket findBasketByUserLogin (String userLogin) throws ServiceException;
    void changeTotal(double newTotal, int basketId) throws ServiceException;

}
