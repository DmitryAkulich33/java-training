package by.epam.bakery.controller;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.FeedBackDao;
import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.FeedBack;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import java.time.LocalDateTime;
import java.util.List;

public class Runner {
    private static DaoHelperFactory daoHelperFactory = new DaoHelperFactory();
    public static void main(String[] args) throws DaoException, ServiceException {
        DaoHelper daoHelper = daoHelperFactory.create();
        UserDao userDao = daoHelper.createUserDao();
        PieDao pieDao = daoHelper.createPieDao();
        FeedBackDao feedBackDao = daoHelper.createFeedBackDao();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        userDao.changeName("Ivan", 3);
        User user = userDao.findUserByLoginAndPassword("user1", "user1");
        System.out.println(user);

//        serviceFactory.getFeedBackService().save(user.getId(), LocalDateTime.parse("2020-02-02T09:00:00"), "It was delicious!");
        System.out.println(LocalDateTime.parse("2020-02-02T09:00:00"));

        System.out.println();


        List<Pie> pies = pieDao.sortByIncreasePrice();
        for(Pie piesTest : pies) {
            System.out.println(piesTest);
        }
        System.out.println();
    }
}
