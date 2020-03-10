package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.User;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException;
    Optional<User> findBySurname(String surname) throws DaoException;
    void changeNote(int userId) throws DaoException;
}
