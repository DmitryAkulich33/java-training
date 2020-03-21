package by.epam.bakery.controller;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.FeedBackDao;
import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.impl.FeedBackDaoImpl;
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

//        serviceFactory.getFeedBackService().save(4, LocalDateTime.now(), "It was delicious, too!");

        System.out.println();

        List<FeedBack> feedBacks = serviceFactory.getFeedBackService().showAllFeedBacks();
        for(FeedBack feedbackTest : feedBacks) {
            System.out.println(feedbackTest);
        }
        System.out.println();

        LocalDateTime localDateTime = LocalDateTime.parse("2020-02-02T09:00:00");
        System.out.println(localDateTime.toString().replace("T", " "));
        System.out.println("d\"d");
        System.out.println(LocalDateTime.now().toString().substring(0, 19));
    }
}
