package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.BasketProduct;

public interface BasketProductDao extends Dao<BasketProduct> {
    void removeByBasketId(int basketId) throws DaoException;
}
