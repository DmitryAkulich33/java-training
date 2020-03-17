package by.epam.bakery.controller;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;

import java.util.List;

public class Runner {
    private static DaoHelperFactory daoHelperFactory = new DaoHelperFactory();
    public static void main(String[] args) throws DaoException {
        DaoHelper daoHelper = daoHelperFactory.create();
        UserDao userDao = daoHelper.createUserDao();
        PieDao pieDao = daoHelper.createPieDao();
        User user = userDao.findUserByLoginAndPassword("user1", "user1");
//        List<User> users = userDao.getAllClients();
        System.out.println(user);
        System.out.println();
        List<Pie> pies = pieDao.sortByIncreasePrice();
        for(Pie piesTest : pies) {
            System.out.println(piesTest);
        }
        System.out.println();
        List<Pie> pies2 = pieDao.sortByReducePrice();
        for(Pie piesTest : pies2) {
            System.out.println(piesTest);
        }
    }
}
