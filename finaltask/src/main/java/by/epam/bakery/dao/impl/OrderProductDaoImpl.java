package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.OrderProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.mapper.impl.OrderProductRowMapper;
import by.epam.bakery.domain.OrderProduct;

import java.sql.Connection;
import java.util.List;

public class OrderProductDaoImpl extends AbstractDao<OrderProduct> implements OrderProductDao {
    private static final String ORDER_PRODUCT_TABLE = "order_product";
    private static final String ID_ORDER_PRODUCT = "id_order_product";
    private static final String SAVE_ORDER_PRODUCT = "INSERT INTO `order_product` (order_id, pie_id)" +
            " VALUES(?, ?)";
    private static final String FIND_ORDER_PRODUCT_BY_USER_ID = "SELECT * FROM order_product INNER JOIN `order` ON order_product.order_id=`order`.id_order INNER JOIN pie ON order_product.pie_id=pie.id_pie INNER JOIN user ON `order`.user_id=user.id_user WHERE user_id = ? ORDER BY id_order DESC";


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

    @Override
    public List<OrderProduct> findByUserId(int userId) throws DaoException {
        return executeQuery(FIND_ORDER_PRODUCT_BY_USER_ID, new OrderProductRowMapper(), userId);
    }
}
