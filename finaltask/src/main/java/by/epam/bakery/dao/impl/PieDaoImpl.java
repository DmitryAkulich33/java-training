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

    }
}
