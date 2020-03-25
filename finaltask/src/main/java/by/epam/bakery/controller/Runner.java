package by.epam.bakery.controller;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.FeedbackDao;
import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Feedback;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;

import java.util.List;

public class Runner {
    private static DaoHelperFactory daoHelperFactory = new DaoHelperFactory();
    public static void main(String[] args) throws DaoException, ServiceException {
        DaoHelper daoHelper = daoHelperFactory.create();
        UserDao userDao = daoHelper.createUserDao();
        PieDao pieDao = daoHelper.createPieDao();
        FeedbackDao feedBackDao = daoHelper.createFeedBackDao();
        ServiceFactory serviceFactory = ServiceFactory.getInstance();

        userDao.changeName("Ivan", 3);
        User user = userDao.findUserByLoginAndPassword("user1", "user1");
        System.out.println(user);
//        serviceFactory.getFeedBackService().save(4, LocalDateTime.now(), "It was delicious, too!");
        System.out.println();
//        List<Feedback> feedbacks = serviceFactory.getFeedBackService().showAllFeedBacks();
//        List<Feedback> feedbacks2 = serviceFactory.getFeedBackService().findNecessaryFeedbackAmount(5, feedbacks);
//        for(Feedback feedbackTest : feedbacks2) {
//            System.out.println(feedbackTest);
//        }
        System.out.println();
//        serviceFactory.getPieService().deletePie(7);
//        Pie pie = serviceFactory.getPieService().findPieById(5);
//        System.out.println(pie);
//        LocalDateTime localDateTime = LocalDateTime.parse("2020-02-02T09:00:00");
//        System.out.println(localDateTime.toString().replace("T", " "));
//        System.out.println("d\"d");
//        System.out.println(LocalDateTime.now().toString().substring(0, 19));
//        serviceFactory.getOrderService().save(4, 76.00, null, null, StatusEnum.NOTREADY.getValue());
    }
}
