package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.Dao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.mapper.RowMapper;
import by.epam.bakery.domain.Entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public abstract class AbstractDao<T extends Entity> implements Dao<T> {
    private Connection connection;
    private static final String FIND_ALL = "SELECT * FROM ";
    private static final String REMOVE_BY_ID = "DELETE FROM ";
    private static final String WHERE = " WHERE ";

    AbstractDao(Connection connection) {
        this.connection = connection;
    }

    List<T> executeQuery(String query, RowMapper<T> mapper, Object... params) throws DaoException {
        List<T> entities = new ArrayList<>();
        try (PreparedStatement statement = createStatement(query, params); ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                T entity = mapper.map(resultSet);
                entities.add(entity);
            }
        } catch (SQLException ex) {
            throw new DaoException(ex.getMessage());
        }
        return entities;
    }

    void executeUpdate(String query, Object... params) throws DaoException {
        try (PreparedStatement statement = createStatement(query, params)) {
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new DaoException(e);
        }
    }

    PreparedStatement createStatement(String query, Object... params) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(query);
        int arrayLength = params.length;
        for (int i = 1; i <= arrayLength; i++) {
            statement.setObject(i, params[i - 1]);
        }
        return statement;
    }

    Optional<T> executeForSingleResult(String query, RowMapper<T> builder, Object... params) throws DaoException {
        List<T> items = executeQuery(query, builder, params);
        if (items.size() == 1) {
            return Optional.of(items.get(0));
        } else if (items.size() > 1) {
            throw new DaoException("More than one record found");
        } else {
            return Optional.empty();
        }
    }

    @Override
    public List<T> findAll() throws DaoException {
        String table = getTableName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        return executeQuery(FIND_ALL + table, mapper);
    }

//    @Override
//    public void save(String query, Object... parameters) throws DaoException {
//        executeUpdate(query, parameters);
//    }

    @Override
    public void removeById(int id) throws DaoException {
        String table = getTableName();
        String idName = getIdName();
//        executeUpdate(REMOVE_BY_ID + table + WHERE + idName, id);
        String query = REMOVE_BY_ID + table + WHERE + idName + " = ?";
        executeUpdate(query, id);
    }

    @Override
    public Optional<T> findById(int id) throws DaoException {
        String table = getTableName();
        String idName = getIdName();
        RowMapper<T> mapper = (RowMapper<T>) RowMapper.create(table);
        String query = FIND_ALL + table + WHERE + idName + " =? ";
//        return executeForSingleResult(FIND_ALL + table + WHERE + idName, mapper, id);
        return executeForSingleResult(query, mapper, id);
    }

    protected abstract String getTableName();

    protected abstract String getIdName();
}

