package by.epam.bakery.dao.api;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends Dao<User> {
    User findUserByLoginAndPassword(String login, String password) throws DaoException;
    void changeNote(String note, int userId) throws DaoException;
    List<User> getLimitClients(int start, int amount) throws DaoException;
    void changeName(String newName, int userId) throws DaoException;
    void changeSurname(String newSurname, int userId) throws DaoException;
    void changePatronymic(String newPatronymic, int userId) throws DaoException;
    void changeAddress(String newAddress, int userId) throws DaoException;
    void changePhone(String newPhone, int userId) throws DaoException;
    void changeRole(String newRole, int userId) throws DaoException;
    User findClientById(String userId) throws DaoException;
    int findClientsAmount () throws DaoException;
    List<User> findUserByLogin(String login) throws DaoException;
}
