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

    public PieDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public List<Pie> sortByIncreasePrice(List<Pie> pies) throws DaoException {
        return null;
    }

    @Override
    public List<Pie> sortByDecreasePrice(List<Pie> pies) throws DaoException {
        return null;
    }

    @Override
    public List<Pie> findByWeight(int weight) throws DaoException {
        return executeQuery(FIND_BY_WEIGHT, new PieRowMapper(), weight);
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
