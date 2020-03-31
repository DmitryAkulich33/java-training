package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.BasketProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.mapper.impl.PieRowMapper;
import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.domain.Pie;

import java.sql.Connection;
import java.util.List;

public class BasketProductDaoImpl extends AbstractDao<BasketProduct> implements BasketProductDao {
    private static final String BASKET_PRODUCT_TABLE = "basket_product";
    private static final String ID_BASKET_PRODUCT = "id_basket_product";
    private static final String SAVE_BASKET_PRODUCT = "INSERT INTO basket_product (basket_id, pie_id)" +
            " VALUES(?, ?)";
    private static final String DELETE_BASKET_PRODUCT = "DELETE FROM basket_product WHERE basket_id = ? ";
    private static final String DELETE_BASKET_PRODUCT_BY_PIE_ID = "DELETE FROM basket_product WHERE basket_id = ? AND pie_id = ? ";

    public BasketProductDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return BASKET_PRODUCT_TABLE;
    }

    @Override
    protected String getIdName() {
        return ID_BASKET_PRODUCT;
    }

    @Override
    public void save(Object... parameters) throws DaoException {
        executeUpdate(SAVE_BASKET_PRODUCT, parameters);
    }

    @Override
    public void removeByBasketId(int basketId) throws DaoException {
        executeUpdate(DELETE_BASKET_PRODUCT, basketId);
    }

    @Override
    public void removeBasketProductByPieId(int basketId, int pieId) throws DaoException {
        executeUpdate(DELETE_BASKET_PRODUCT_BY_PIE_ID, basketId, pieId);
    }
}
