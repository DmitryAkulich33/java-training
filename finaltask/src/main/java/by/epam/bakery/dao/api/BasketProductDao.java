package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.BasketProduct;

import java.util.List;

public interface BasketProductDao extends Dao<BasketProduct> {
    void removeByBasketId(int basketId) throws DaoException;
    List<BasketProduct> findByBasketId(int basketId) throws DaoException;
}
