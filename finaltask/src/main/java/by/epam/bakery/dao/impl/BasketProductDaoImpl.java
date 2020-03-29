package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.BasketProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.BasketProduct;

import java.sql.Connection;

public class BasketProductDaoImpl extends AbstractDao<BasketProduct> implements BasketProductDao {
    private static final String BASKET_PRODUCT_TABLE = "basket_product";
    private static final String ID_BASKET_PRODUCT = "id_basket_product";
    private static final String SAVE_BASKET_PRODUCT = "INSERT INTO basket_product (basket_id, pie_id)" +
            " VALUES(?, ?)";

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
}
