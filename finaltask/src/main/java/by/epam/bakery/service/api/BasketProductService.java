package by.epam.bakery.service.api;

import by.epam.bakery.service.exception.ServiceException;

public interface BasketProductService {
    void saveBasketProduct(int basketId, int pieId) throws ServiceException;
    void deleteBasketProductByBasketId(int basketId) throws ServiceException;
}
