package by.epam.bakery.service.api;

import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public interface BasketProductService {
    void saveBasketProduct(int basketId, int pieId, int amount, double cost) throws ServiceException;
    void deleteBasketProductByBasketId(int basketId) throws ServiceException;
    void deleteBasketProductById(int basketProductId) throws ServiceException;
    List<BasketProduct> findProductByBasketId(int basketId) throws ServiceException;
}
