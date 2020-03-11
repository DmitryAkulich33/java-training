package by.epam.bakery.controller;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.connection.ConnectionPool;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.impl.UserDaoImpl;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.UserService;

import java.util.List;
import java.util.Optional;

public class Runner {
    private static DaoHelperFactory daoHelperFactory = new DaoHelperFactory();
    public static void main(String[] args) throws DaoException {
        DaoHelper daoHelper = daoHelperFactory.create();
        UserDao userDao = daoHelper.createUserDao();
        Optional<User> user = userDao.findById(5);
        System.out.println(user);
        List<User> users = userDao.getAllClients();
        for(User userTest : users) {
            System.out.println(userTest);
        }

    }
}
