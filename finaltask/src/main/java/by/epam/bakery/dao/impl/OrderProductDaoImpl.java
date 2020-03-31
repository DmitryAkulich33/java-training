package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.OrderProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.OrderProduct;

import java.sql.Connection;

public class OrderProductDaoImpl extends AbstractDao<OrderProduct> implements OrderProductDao {
    private static final String ORDER_PRODUCT_TABLE = "order_product";
    private static final String ID_ORDER_PRODUCT = "id_order_product";
    private static final String SAVE_ORDER_PRODUCT = "INSERT INTO `order_product` (order_id, pie_id)" +
            " VALUES(?, ?)";

    public OrderProductDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return ORDER_PRODUCT_TABLE;
    }

    @Override
    protected String getIdName() {
        return ID_ORDER_PRODUCT;
    }

    @Override
    public void save(Object... parameters) throws DaoException {
        executeUpdate(SAVE_ORDER_PRODUCT, parameters);
    }
}
