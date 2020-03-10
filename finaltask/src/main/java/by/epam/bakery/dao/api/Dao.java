package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Entity;

import java.util.List;
import java.util.Optional;

public interface Dao<T extends Entity> {
    Optional<T> findById(int id) throws DaoException;

    List<T> findAll() throws DaoException;

    void save(String query, Object... parameters) throws DaoException;

    void removeById(int id) throws DaoException;
}
