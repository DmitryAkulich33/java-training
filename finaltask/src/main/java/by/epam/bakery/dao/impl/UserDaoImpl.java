package by.epam.bakery.dao.impl;

import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.mapper.impl.UserRowMapper;
import by.epam.bakery.domain.User;

import java.sql.Connection;
import java.util.List;
import java.util.Optional;

public class UserDaoImpl extends AbstractDao<User> implements UserDao {
    public static final String USER_TABLE = "user";
    public static final String ID_USER = "id_user";
    private static final String FIND_BY_LOGIN_AND_PASSWORD ="SELECT * FROM user WHERE login = ? AND password = ?";
    private static final String FIND_BY_SURNAME ="SELECT * FROM user WHERE surname = ?";
//    private static final String FIND_BY_ID ="SELECT * FROM user WHERE id_user = ?";
    private static final String FIND_ALL_CLIENTS ="SELECT * FROM user WHERE role = 3";
    private static final String CHANGE_NOTE = "UPDATE user SET note = ? WHERE id_user = ?";
//    private static final String REMOVE_USER_BY_ID = "DELETE FROM user WHERE id_user = ?";
    private static final String SAVE_USER = "INSERT INTO user (login, password, role, surname, name_user, patronymic, address, phone, note)" +
            " VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public UserDaoImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Optional<User> findUserByLoginAndPassword(String login, String password) throws DaoException {
        return executeForSingleResult(FIND_BY_LOGIN_AND_PASSWORD, new UserRowMapper(), login, password);
    }

    @Override
    public Optional<User> findUserBySurname(String surname) throws DaoException {
        return executeForSingleResult(FIND_BY_SURNAME, new UserRowMapper(), surname);
    }

    @Override
    public void changeNote(String note, int userId) throws DaoException {
        executeUpdate(CHANGE_NOTE, note, userId);
    }

    @Override
    public List<User> getAllClients() throws DaoException {
        return executeQuery(FIND_ALL_CLIENTS, new UserRowMapper());
    }

//    @Override
//    public Optional<User> findById(int id) throws DaoException {
//        return executeForSingleResult(FIND_BY_ID, new UserRowMapper(), id);
//    }

//    @Override
//    public void removeById(int id) throws DaoException {
//        executeUpdate(REMOVE_USER_BY_ID, id);
//    }

    @Override
    public void save(Object... parameters) throws DaoException {
        executeUpdate(SAVE_USER, parameters);
    }

    @Override
    protected String getTableName() {
        return USER_TABLE;
    }

    @Override
    protected String getIdName() {
        return ID_USER;
    }
}
