package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.BlackList;

public interface BlackListDao extends Dao<BlackList> {
    void addUser (int userId) throws DaoException;
}
