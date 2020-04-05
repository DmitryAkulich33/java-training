package by.epam.bakery.controller;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.FeedbackDao;
import by.epam.bakery.dao.api.OrderProductDao;
import by.epam.bakery.dao.api.PieDao;
import by.epam.bakery.dao.api.UserDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.dao.impl.OrderProductDaoImpl;
import by.epam.bakery.domain.*;
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


//        System.out.println(localDateTime.toString().replace("T", " "));
//        System.out.println("d\"d");
//        System.out.println(LocalDateTime.now().toString().substring(0, 19));
//        serviceFactory.getOrderService().save(4, 76.00, null, null, StatusEnum.NOTREADY.getValue());
//        serviceFactory.getBasketService().save(3, 22);
        Basket basket = serviceFactory.getBasketService().findBasketByUserLogin("user7");
        System.out.println(basket);
//        serviceFactory.getBasketProductService().saveBasketProduct(2, 4);
//        List<Pie> pies = pieDao.findPieByBasketId(1);
//        System.out.println(pies);
//        serviceFactory.getOrderService().save(6, 99.0, null,null, StatusEnum.NOT_READY.getValue());
//        Order order = serviceFactory.getOrderService().findLastOrderByUserId(6);
//        System.out.println(order);
//        OrderProductDao dao = daoHelper.createOrderProductDao();
//        List<OrderProduct> lists = dao.findByUserId(4);
//        for(OrderProduct orderProduct : lists) {
//            System.out.println(orderProduct);
//        }
//        serviceFactory.getOrderService().changeProductionDate(LocalDateTime.parse("2020-04-02T23:55:00"), 3);
//        serviceFactory.getOrderService().changeStatus("not ready", 3);
        OrderProduct orderProduct = serviceFactory.getOrderProductService().findOrderProductById(32);
        System.out.println(orderProduct.getOrder().getTotal());

    }
}
