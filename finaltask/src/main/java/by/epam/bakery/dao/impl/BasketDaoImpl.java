package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.BasketDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.mapper.impl.BasketRowMapper;
import by.epam.bakery.domain.Basket;

import java.sql.Connection;
import java.util.List;

public class BasketDaoImpl extends AbstractDao<Basket> implements BasketDao {
    private static final String BASKET_TABLE = "basket";
    private static final String ID_BASKET = "id_basket";
    private static final String SAVE_BASKET = "INSERT INTO basket (user_login, total)" +
            " VALUES(?, ?)";
    private static final String FIND_BASKET_BY_USER_LOGIN ="SELECT * FROM user INNER JOIN basket ON user.login=basket.user_login WHERE login = ? ";
    private static final String CHANGE_TOTAL = "UPDATE basket SET total = ? WHERE id_basket = ?";


    public BasketDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return BASKET_TABLE;
    }

    @Override
    protected String getIdName() {
        return ID_BASKET;
    }

    @Override
    public void save(Object... parameters) throws DaoException {
        executeUpdate(SAVE_BASKET, parameters);
    }

    @Override
    public Basket getBasketByUserLogin(String userLogin) throws DaoException {
        return executeForSingleResult(FIND_BASKET_BY_USER_LOGIN, new BasketRowMapper(), userLogin);
    }

    @Override
    public void changeTotal(double newTotal, int basketId) throws DaoException {
        executeUpdate(CHANGE_TOTAL, newTotal, basketId);
    }
}
