package by.epam.bakery.service.api;

import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;

import java.util.List;

public interface BasketProductService {
    void saveBasketProduct(int basketId, int pieId, String amount, double price, double newTotal) throws ServiceException, ValidatorException;

    void deleteBasketProductById(int basketProductId, double newTotal, int basketId) throws ServiceException;

    List<BasketProduct> findProductByBasketId(int basketId) throws ServiceException;

    void clearBasket(int basketId, double newTotal) throws ServiceException;
}
