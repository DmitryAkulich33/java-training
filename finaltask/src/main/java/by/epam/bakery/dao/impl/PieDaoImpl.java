package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.mapper.impl.PieRowMapper;
import by.epam.bakery.domain.Pie;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class PieDaoImpl extends AbstractDao<Pie> implements PieDao {
    private static final String PIE_TABLE = "pie";
    private static final String ID_PIE = "id_pie";
    private static final String FIND_BY_WEIGHT ="SELECT * FROM pie WHERE weight = ?";
    private static final String SORT_BY_INCREASE_PRICE ="SELECT * FROM pie ORDER BY price";
    private static final String SORT_BY_DECREASE_PRICE ="SELECT * FROM pie ORDER BY price DESC";
    private static final String FIND_BY_NAME ="SELECT * FROM pie WHERE name_pie = ?";
    private static final String SAVE_PIE = "INSERT INTO pie (name_pie, weight, price, description, picture)" +
            " VALUES(?, ?, ?, ?, ?)";
    private static final String CHANGE_NAME = "UPDATE pie SET name_pie = ? WHERE id_pie = ?";
    private static final String CHANGE_PICTURE = "UPDATE pie SET picture = ? WHERE id_pie = ?";
    private static final String CHANGE_DESCRIPTION = "UPDATE pie SET description = ? WHERE id_pie = ?";
    private static final String CHANGE_WEIGHT = "UPDATE pie SET weight = ? WHERE id_pie = ?";
    private static final String CHANGE_PRICE = "UPDATE pie SET price = ? WHERE id_pie = ?";
    private static final String FIND_PIE_BY_BASKET_ID ="SELECT * FROM pie INNER JOIN basket_product ON pie.id_pie=basket_product.pie_id WHERE basket_id = ? ";

    public PieDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Pie> sortByIncreasePrice() throws DaoException {
        return executeQuery(SORT_BY_INCREASE_PRICE, new PieRowMapper());
    }

    @Override
    public List<Pie> sortByReducePrice() throws DaoException {
        return executeQuery(SORT_BY_DECREASE_PRICE, new PieRowMapper());
    }

    @Override
    public List<Pie> findByWeight(int weight) throws DaoException {
        return executeQuery(FIND_BY_WEIGHT, new PieRowMapper(), weight);
    }

    @Override
    public Pie findByName(String name) throws DaoException {
        return executeForSingleResult(FIND_BY_NAME, new PieRowMapper(), name);
    }

    @Override
    protected String getTableName() {
        return PIE_TABLE;
    }

    @Override
    protected String getIdName() {
        return ID_PIE;
    }

    @Override
    public void save(Object... parameters) throws DaoException {
        executeUpdate(SAVE_PIE, parameters);
    }

    @Override
    public void changeName(String newName, int pieId) throws DaoException {
        executeUpdate(CHANGE_NAME, newName, pieId);
    }

    @Override
    public void changePicture(String newPicture, int pieId) throws DaoException {
        executeUpdate(CHANGE_PICTURE, newPicture, pieId);
    }

    @Override
    public void changeDescription(String newDescription, int pieId) throws DaoException {
        executeUpdate(CHANGE_DESCRIPTION, newDescription, pieId);
    }

    @Override
    public void changeWeight(int newWeight, int pieId) throws DaoException {
        executeUpdate(CHANGE_WEIGHT, newWeight, pieId);
    }

    @Override
    public void changePrice(double newPrice, int pieId) throws DaoException {
        executeUpdate(CHANGE_PRICE, newPrice, pieId);
    }

    @Override
    public List<Pie> findPieByBasketId(int basketId) throws DaoException {
        return executeQuery(FIND_PIE_BY_BASKET_ID, new PieRowMapper(), basketId);
    }
}
