package by.epam.bakery.service.impl;

import by.epam.bakery.domain.*;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class OrderProductServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @DataProvider
    public Object[][] forFindLimitOrderProduct() {
        List<OrderProduct> orderProducts1 = new ArrayList<>(Arrays.asList(new OrderProduct(6, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new OrderProduct(5, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png"), 1, 25.00),
                new OrderProduct(4, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"), 1, 26.00)));
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
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00)));
        int start = 0;
        int amount1 = 1;
        int amount2 = 2;
        return new Object[][]{
                {orderProducts1, start, amount1},
                {orderProducts2, start, amount2}
        };
    }

    @Test(dataProvider = "forFindLimitOrderProduct")
    public void testFindLimitOrderProduct(List<OrderProduct> orderProducts, int start, int amount) throws ServiceException {
        Assert.assertEquals(serviceFactory.getOrderProductService().findLimitOrderProduct(start, amount), orderProducts);
    }

    @DataProvider
    public Object[][] forFindLimitOrderProductByUserId() {
        List<OrderProduct> orderProducts1 = new ArrayList<>(Arrays.asList(new OrderProduct(6, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new OrderProduct(5, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png"), 1, 25.00),
                new OrderProduct(4, new Order(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), 75.00, LocalDateTime.parse("2020-04-04T09:00:00"), LocalDateTime.parse("2020-04-04T17:30:00"), StatusEnum.DELIVERED),
                        new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"), 1, 26.00)));
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
                        new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00)));
        int start = 0;
        int amount1 = 1;
        int amount2 = 3;
        return new Object[][]{
                {orderProducts1, start, amount1},
                {orderProducts2, start, amount2}
        };
    }

    @Test(dataProvider = "forFindLimitOrderProductByUserId")
    public void testFindLimitOrderProductByUserId(List<OrderProduct> orderProducts, int start, int amount) throws ServiceException {
        int userId = 4;
        Assert.assertEquals(serviceFactory.getOrderProductService().findLimitOrderProductByUserId(userId, start, amount), orderProducts);
    }
}