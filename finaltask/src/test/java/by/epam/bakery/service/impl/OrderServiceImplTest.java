package by.epam.bakery.service.impl;

import by.epam.bakery.domain.*;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class OrderServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @DataProvider
    public Object[][] forFindCorrectOrderPageAmount() {
        int ordersOnPage1 = 1;
        int ordersOnPage2 = 2;
        int ordersOnPage3 = 3;
        int pageAmount1 = 3;
        int pageAmount2 = 2;
        int pageAmount3 = 1;
        return new Object[][]{
                {ordersOnPage1, pageAmount1},
                {ordersOnPage2, pageAmount2},
                {ordersOnPage3, pageAmount3},
        };
    }

    @Test(dataProvider = "forFindCorrectOrderPageAmount")
    public void testFindCorrectOrderPageAmount(int ordersOnPage, int pageAmount) throws ServiceException {
        Assert.assertEquals(serviceFactory.getOrderService().findOrderPageAmount(ordersOnPage), pageAmount);
    }

    @DataProvider
    public Object[][] forFindWrongOrderPageAmount() {
        int ordersOnPage1 = 1;
        int ordersOnPage2 = 2;
        int ordersOnPage3 = 3;
        int pageAmount1 = 2;
        int pageAmount2 = 3;
        int pageAmount3 = 2;
        return new Object[][]{
                {ordersOnPage1, pageAmount1},
                {ordersOnPage2, pageAmount2},
                {ordersOnPage3, pageAmount3},
        };
    }

    @Test(dataProvider = "forFindWrongOrderPageAmount")
    public void testFindWrongOrderPageAmount(int ordersOnPage, int pageAmount) throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getOrderService().findOrderPageAmount(ordersOnPage), pageAmount);
    }

    @DataProvider
    public Object[][] forFindCorrectOrderByUserIdPageAmount() {
        int ordersOnPage1 = 1;
        int ordersOnPage2 = 1;
        int pageAmount1 = 1;
        int pageAmount2 = 2;
        int userId1 = 3;
        int userId2 = 4;
        return new Object[][]{
                {ordersOnPage1, pageAmount1, userId1},
                {ordersOnPage2, pageAmount2, userId2}
        };
    }

    @Test(dataProvider = "forFindCorrectOrderByUserIdPageAmount")
    public void testFindCorrectOrderByUserIdPageAmount(int ordersOnPage, int pageAmount, int userId) throws ServiceException {
        Assert.assertEquals(serviceFactory.getOrderService().findOrderByUserIdPageAmount(ordersOnPage, userId), pageAmount);
    }

    @DataProvider
    public Object[][] forFindWrongOrderByUserIdPageAmount() {
        int ordersOnPage1 = 1;
        int ordersOnPage2 = 1;
        int pageAmount1 = 2;
        int pageAmount2 = 1;
        int userId1 = 3;
        int userId2 = 4;
        return new Object[][]{
                {ordersOnPage1, pageAmount1, userId1},
                {ordersOnPage2, pageAmount2, userId2}
        };
    }

    @Test(dataProvider = "forFindWrongOrderByUserIdPageAmount")
    public void testFindWrongOrderByUserIdPageAmount(int ordersOnPage, int pageAmount, int userId) throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getOrderService().findOrderByUserIdPageAmount(ordersOnPage, userId), pageAmount);
    }

    @Test
    public void testFindOrdersAmount() throws ServiceException {
        double ordersAmount = 3;
        Assert.assertEquals(serviceFactory.getOrderService().findOrdersAmount(), ordersAmount);
    }

    @Test
    public void testFindOrdersCost() throws ServiceException {
        double ordersCost = 169.00;
        Assert.assertEquals(serviceFactory.getOrderService().findOrdersCost(), ordersCost);
    }

    @DataProvider
    public Object[][] forChangeDate() {
        String newDate1 = "2020-04-02T09:00:00";
        String newDate2 = "2020-04-03 15:00:00";
        String newDate3 = "2021-04-02T25:00:00";
        int orderId1 = 1;
        int orderId2 = 2;
        int orderId3 = 3;
        return new Object[][]{
                {newDate1, orderId1},
                {newDate2, orderId2},
                {newDate3, orderId3}
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangeDate")
    public void testChangeProductionDate(String newDate, int orderId) throws ServiceException, ValidatorException {
        serviceFactory.getOrderService().changeProductionDate(newDate, orderId);
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangeDate")
    public void testChangeDeliveryDate(String newDate, int orderId) throws ServiceException, ValidatorException {
        serviceFactory.getOrderService().changeDeliveryDate(newDate, orderId);
    }

    @DataProvider
    public Object[][] forChangeStatus() {
        String newStatus1 = "";
        String newStatus2 = "1ready";
        String newStatus3 = "r eady";
        int orderId1 = 1;
        int orderId2 = 2;
        int orderId3 = 3;
        return new Object[][]{
                {newStatus1, orderId1},
                {newStatus2, orderId2},
                {newStatus3, orderId3}
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangeStatus")
    public void testChangeStatus(String newStatus, int orderId) throws ServiceException, ValidatorException {
        serviceFactory.getOrderService().changeStatus(newStatus, orderId);
    }

    @DataProvider
    public Object[][] forSaveOrder() {
        List<OrderProduct> orderProducts1 = new ArrayList<>(Arrays.asList(new OrderProduct(7, new Order(4, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), 48.00, null, null, StatusEnum.NOT_READY),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 2, 48.00),
                new OrderProduct(6, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new OrderProduct(5, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png"), 1, 25.00),
                new OrderProduct(4, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"), 1, 26.00),
                new OrderProduct(3, new Order(2, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 46.00, LocalDateTime.parse("2020-04-03T09:00:00"), LocalDateTime.parse("2020-04-03T18:00:00"), StatusEnum.DELIVERED),
                        new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"), 1, 22.00),
                new OrderProduct(2, new Order(2, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 46.00, LocalDateTime.parse("2020-04-03T09:00:00"), LocalDateTime.parse("2020-04-03T18:00:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new OrderProduct(1, new Order(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), 48.00, LocalDateTime.parse("2020-04-02T09:00:00"), LocalDateTime.parse("2020-04-02T15:00:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 2, 48.00)));
        List<OrderProduct> orderProducts2 = new ArrayList<>(Arrays.asList(new OrderProduct(8, new Order(5, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), 22.00, null, null, StatusEnum.NOT_READY),
                        new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"), 1, 22.00),
                new OrderProduct(7, new Order(4, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), 48.00, null, null, StatusEnum.NOT_READY),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 2, 48.00),
                new OrderProduct(6, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new OrderProduct(5, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png"), 1, 25.00),
                new OrderProduct(4, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"), 1, 26.00),
                new OrderProduct(3, new Order(2, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 46.00, LocalDateTime.parse("2020-04-03T09:00:00"), LocalDateTime.parse("2020-04-03T18:00:00"), StatusEnum.DELIVERED),
                        new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"), 1, 22.00),
                new OrderProduct(2, new Order(2, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 46.00, LocalDateTime.parse("2020-04-03T09:00:00"), LocalDateTime.parse("2020-04-03T18:00:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new OrderProduct(1, new Order(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), 48.00, LocalDateTime.parse("2020-04-02T09:00:00"), LocalDateTime.parse("2020-04-02T15:00:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 2, 48.00)));
        List<BasketProduct> basketProducts1 = new ArrayList<>(Collections.singletonList(new BasketProduct(1, new Basket(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces"), 48.0), new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 2, 48.00)));
        List<BasketProduct> basketProducts2 = new ArrayList<>(Collections.singletonList(new BasketProduct(1, new Basket(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces"), 22.0), new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"), 1, 22.00)));
        int start = 0;
        int amount1 = 7;
        int amount2 = 8;
        int userId = 3;
        double orderTotal1 = 48.00;
        double orderTotal2 = 22.00;
        String login = "user1";
        return new Object[][]{
                {orderProducts1, start, amount1, userId, orderTotal1, basketProducts1 , login},
                {orderProducts2, start, amount2, userId, orderTotal2, basketProducts2 , login}
        };
    }

    @Test(priority = 1, dataProvider = "forSaveOrder")
    public void testSaveOrder(List<OrderProduct> orderProducts, int start, int amount, int userId, double orderTotal,
                         List<BasketProduct> basketProducts, String login) throws ServiceException {
        serviceFactory.getOrderService().saveOrder(userId, orderTotal, null, null, StatusEnum.NOT_READY.getValue(),
                basketProducts, login, 0.0);
        Assert.assertEquals(serviceFactory.getOrderProductService().findLimitOrderProduct(start, amount), orderProducts);
    }

    @DataProvider
    public Object[][] forDeleteOrder() {
        List<OrderProduct> orderProducts1 = new ArrayList<>(Arrays.asList(new OrderProduct(7, new Order(4, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), 48.00, null, null, StatusEnum.NOT_READY),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 2, 48.00),
                new OrderProduct(6, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new OrderProduct(5, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png"), 1, 25.00),
                new OrderProduct(4, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"), 1, 26.00),
                new OrderProduct(3, new Order(2, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 46.00, LocalDateTime.parse("2020-04-03T09:00:00"), LocalDateTime.parse("2020-04-03T18:00:00"), StatusEnum.DELIVERED),
                        new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"), 1, 22.00),
                new OrderProduct(2, new Order(2, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 46.00, LocalDateTime.parse("2020-04-03T09:00:00"), LocalDateTime.parse("2020-04-03T18:00:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new OrderProduct(1, new Order(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), 48.00, LocalDateTime.parse("2020-04-02T09:00:00"), LocalDateTime.parse("2020-04-02T15:00:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 2, 48.00)));
        List<OrderProduct> orderProducts2 = new ArrayList<>(Arrays.asList(new OrderProduct(6, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new OrderProduct(5, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png"), 1, 25.00),
                new OrderProduct(4, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"), 1, 26.00),
                new OrderProduct(3, new Order(2, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 46.00, LocalDateTime.parse("2020-04-03T09:00:00"), LocalDateTime.parse("2020-04-03T18:00:00"), StatusEnum.DELIVERED),
                        new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"), 1, 22.00),
                new OrderProduct(2, new Order(2, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 46.00, LocalDateTime.parse("2020-04-03T09:00:00"), LocalDateTime.parse("2020-04-03T18:00:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new OrderProduct(1, new Order(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), 48.00, LocalDateTime.parse("2020-04-02T09:00:00"), LocalDateTime.parse("2020-04-02T15:00:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 2, 48.00)));
        int start = 0;
        int amount1 = 7;
        int amount2 = 8;
        int orderId1 = 5;
        int orderId2 = 4;
        return new Object[][]{
                {orderProducts1, start, amount1, orderId1},
                {orderProducts2, start, amount2, orderId2}
        };
    }

    @Test(priority = 2, dataProvider = "forDeleteOrder")
    public void testDeleteOrder(List<OrderProduct> orderProducts, int start, int amount, int orderId) throws ServiceException {
        serviceFactory.getOrderService().deleteOrderById(orderId);
        Assert.assertEquals(serviceFactory.getOrderProductService().findLimitOrderProduct(start, amount), orderProducts);
    }
}