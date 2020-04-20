package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Basket;

public interface BasketDao extends Dao<Basket> {
    Basket getBasketByUserLogin(String userLogin) throws DaoException;
    void changeTotal(double newTotal, int basketId) throws DaoException;
}
