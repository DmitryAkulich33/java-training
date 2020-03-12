package by.epam.bakery.controller;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.connection.ConnectionPool;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.impl.UserDaoImpl;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.UserService;

import java.util.List;
import java.util.Optional;

public class Runner {
    private static DaoHelperFactory daoHelperFactory = new DaoHelperFactory();
    public static void main(String[] args) throws DaoException {
        DaoHelper daoHelper = daoHelperFactory.create();
//        UserDao userDao = daoHelper.createUserDao();
        PieDao pieDao = daoHelper.createPieDao();
//        Optional<User> user = userDao.findById(7);
//        List<User> users = userDao.getAllClients();
        List<Pie> pies = pieDao.findByWeight(1000);
        for(Pie piesTest : pies) {
            System.out.println(piesTest);
        }

    }
}
