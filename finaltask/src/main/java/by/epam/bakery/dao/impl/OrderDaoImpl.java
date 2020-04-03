package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.OrderDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.mapper.impl.OrderRowMapper;
import by.epam.bakery.domain.Order;
import by.epam.bakery.domain.StatusEnum;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class OrderDaoImpl extends AbstractDao<Order> implements OrderDao {
    private static final String ORDER_TABLE = "`order`";
    private static final String ID_ORDER = "id_order";
    private static final String SAVE_ORDER = "INSERT INTO `order` (user_id, total, productionDate, deliveryDate, status)" +
            " VALUES(?, ?, ?, ?, ?)";
    private static final String FIND_LAST_ORDER = "SELECT * FROM user INNER JOIN `order` ON user.id_user= ? AND `order`.user_id= ? ORDER BY id_order DESC LIMIT 1" ;
    private static final String FIND_ALL_ORDER = "SELECT * FROM `order` INNER JOIN user ON `order`.user_id=user.id_user ORDER BY id_order DESC" ;
    private static final String FIND_LATEST_ORDER = "SELECT * FROM `order` INNER JOIN user ON `order`.user_id=user.id_user ORDER BY id_order DESC LIMIT ?" ;
    private static final String FIND_ORDER_BY_USER_ID = "SELECT * FROM `order` INNER JOIN user ON `order`.user_id=user.id_user WHERE id_user = ? ORDER BY id_order DESC" ;

    public OrderDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    public List<Order> findByUserId(int userId) throws DaoException {
        return executeQuery(FIND_ORDER_BY_USER_ID, new OrderRowMapper(), userId);
    }

    @Override
    public List<Order> findByStatus(StatusEnum statusEnum) throws DaoException {
        return null;
    }

    @Override
    public void changeStatus(int orderId) throws DaoException {

    }

    @Override
    protected String getTableName() {
        return ORDER_TABLE;
    }

    @Override
    protected String getIdName() {
        return ID_ORDER;
    }

    @Override
    public void save(Object... parameters) throws DaoException {
        executeUpdate(SAVE_ORDER, parameters);
    }

    @Override
    public Order findLastUserOrderById(int userId) throws DaoException {
        return executeForSingleResult(FIND_LAST_ORDER, new OrderRowMapper(), userId, userId);
    }

    @Override
    public List<Order> findAllOrders() throws DaoException {
        return executeQuery(FIND_ALL_ORDER, new OrderRowMapper());
    }

    @Override
    public List<Order> findNecessaryOrderAmount(int amount) throws DaoException {
        return executeQuery(FIND_LATEST_ORDER, new OrderRowMapper(), amount);
    }
}
