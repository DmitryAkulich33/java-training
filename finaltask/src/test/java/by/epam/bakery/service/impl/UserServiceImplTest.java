package by.epam.bakery.service.impl;

import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class UserServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    List<User> allUsers = new ArrayList<>(Arrays.asList(new User(1, "admin", "admin", 1, "Akulich", "Dmitry", "Viktorovich", "Apt 229, 33 Lubimova St, Minsk", "8-044-564-61-30", "admin"),
            new User(2, "courier1", "courier1", 2, "Aleksievich", "Aleksey", "Alekseevich", "Apt 110, 31 Lubimova St, Minsk",
                    "8-029-165-61-30", "courier"),
            new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                    "In the yard problems with parking spaces"),
            new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                    "There are enough parking spaces in the yard")));
    private int clientAmount = 2;

    @DataProvider
    public Object[][] forFindClientById() {
        User user1 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                "There are enough parking spaces in the yard");
        String id1 = "3";
        String id2 = "4";
        return new Object[][]{
                {user1, id1},
                {user2, id2}
        };
    }

    @Test(dataProvider = "forFindClientById")
    public void testFindClientById(User user, String id) throws ServiceException, ValidatorException {
        Assert.assertEquals(serviceFactory.getUserService().findClientById(id), user);
    }

    @DataProvider
    public Object[][] forFindClientByIdThrowValidatorException() {
        User user1 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                "There are enough parking spaces in the yard");
        String id1 = "one";
        String id2 = "1 1";
        String id3 = "";
        return new Object[][]{
                {user1, id1},
                {user2, id2},
                {user2, id3}
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forFindClientByIdThrowValidatorException")
    public void testFindClientByIdThrowValidatorException(User user, String id) throws ServiceException, ValidatorException {
        Assert.assertEquals(serviceFactory.getUserService().findClientById(id), user);
    }


    @DataProvider
    public Object[][] forCorrectLogin() {
        User user1 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                "There are enough parking spaces in the yard");
        String login1 = "user1";
        String login2 = "user2";
        String password1 = "user1";
        String password2 = "user2";
        return new Object[][]{
                {user1, login1, password1},
                {user2, login2, password2}
        };
    }

    @Test(dataProvider = "forCorrectLogin")
    public void testCorrectLogin(User user, String login, String password) throws ServiceException, ValidatorException {
        Assert.assertEquals(serviceFactory.getUserService().login(login, password), user);
    }

    @DataProvider
    public Object[][] forWrongLoginThrowServiceException() {
        User user1 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                "There are enough parking spaces in the yard");
        String login1 = "user1";
        String login2 = "user2";
        String password1 = "user2";
        String password2 = "user1";
        return new Object[][]{
                {user1, login1, password1},
                {user2, login2, password2}
        };
    }

    @Test(expectedExceptions = ServiceException.class, dataProvider = "forWrongLoginThrowServiceException")
    public void testWrongLoginThrowServiceException(User user, String login, String password) throws ServiceException, ValidatorException {
        Assert.assertNotEquals(serviceFactory.getUserService().login(login, password), user);
    }

    @DataProvider
    public Object[][] forWrongLoginThrowValidatorException() {
        User user1 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                "There are enough parking spaces in the yard");
        String login1 = "Юзер";
        String login2 = "user2";
        String password1 = "user2";
        String password2 = "пароль";
        return new Object[][]{
                {user1, login1, password1},
                {user2, login2, password2}
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forWrongLoginThrowValidatorException")
    public void testWrongLoginThrowValidatorException(User user, String login, String password) throws ServiceException, ValidatorException {
        Assert.assertNotEquals(serviceFactory.getUserService().login(login, password), user);
    }

    @DataProvider
    public Object[][] forFindCorrectUserPageAmount() {
        int usersOnPage1 = 1;
        int usersOnPage2 = 2;
        int usersOnPage3 = 3;
        int usersOnPage4 = 4;
        int pageAmount1 = 4;
        int pageAmount2 = 2;
        int pageAmount3 = 2;
        int pageAmount4 = 1;
        return new Object[][]{
                {usersOnPage1, pageAmount1},
                {usersOnPage2, pageAmount2},
                {usersOnPage3, pageAmount3},
                {usersOnPage4, pageAmount4}
        };
    }

    @Test(dataProvider = "forFindCorrectUserPageAmount")
    public void testFindCorrectUserPageAmount(int userOnPage, int pageAmount) throws ServiceException {
        Assert.assertEquals(serviceFactory.getUserService().findUserPageAmount(userOnPage), pageAmount);
    }

    @DataProvider
    public Object[][] forFindWrongUserPageAmount() {
        int usersOnPage1 = 1;
        int usersOnPage2 = 2;
        int usersOnPage3 = 3;
        int usersOnPage4 = 4;
        int pageAmount1 = 3;
        int pageAmount2 = 1;
        int pageAmount3 = 3;
        int pageAmount4 = 2;
        return new Object[][]{
                {usersOnPage1, pageAmount1},
                {usersOnPage2, pageAmount2},
                {usersOnPage3, pageAmount3},
                {usersOnPage4, pageAmount4}
        };
    }

    @Test(dataProvider = "forFindWrongUserPageAmount")
    public void testFindWrongUserPageAmount(int userOnPage, int pageAmount) throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getUserService().findUserPageAmount(userOnPage), pageAmount);
    }

    @DataProvider
    public Object[][] forFindCorrectLimitUserOnPage() {
        List<User> users1 = new ArrayList<>(Arrays.asList(new User(1, "admin", "admin", 1, "Akulich", "Dmitry", "Viktorovich", "Apt 229, 33 Lubimova St, Minsk", "8-044-564-61-30", "admin"),
                new User(2, "courier1", "courier1", 2, "Aleksievich", "Aleksey", "Alekseevich", "Apt 110, 31 Lubimova St, Minsk",
                        "8-029-165-61-30", "courier")));
        List<User> users2 = new ArrayList<>(Arrays.asList(new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"),
                new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard")));
        int start1 = 0;
        int start2 = 2;
        int amount = 2;
        return new Object[][]{
                {users1, start1, amount},
                {users2, start2, amount}
        };
    }

    @Test(dataProvider = "forFindCorrectLimitUserOnPage")
    public void testFindCorrectLimitUserOnPage(List<User> users, int start, int amount) throws ServiceException {
        Assert.assertEquals(serviceFactory.getUserService().findLimitUser(start, amount), users);
    }

    @DataProvider
    public Object[][] forFindWrongLimitUserOnPage() {
        List<User> users1 = new ArrayList<>(Arrays.asList(new User(1, "admin", "admin", 1, "Akulich", "Dmitry", "Viktorovich", "Apt 229, 33 Lubimova St, Minsk", "8-044-564-61-30", "admin"),
                new User(2, "courier1", "courier1", 2, "Aleksievich", "Aleksey", "Alekseevich", "Apt 110, 31 Lubimova St, Minsk",
                        "8-029-165-61-30", "courier")));
        List<User> users2 = new ArrayList<>(Arrays.asList(new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"),
                new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard")));
        int start1 = 1;
        int start2 = 3;
        int amount = 2;
        return new Object[][]{
                {users1, start1, amount},
                {users2, start2, amount}
        };
    }

    @Test(dataProvider = "forFindWrongLimitUserOnPage")
    public void testFindWrongLimitUserOnPage(List<User> users, int start, int amount) throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getUserService().findLimitUser(start, amount), users);
    }

    @DataProvider
    public Object[][] forFindCorrectLimitClientsOnPage() {
        List<User> clients1 = new ArrayList<>(Collections.singletonList(new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces")));
        List<User> clients2 = new ArrayList<>(Collections.singletonList(new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                "There are enough parking spaces in the yard")));
        int start1 = 0;
        int start2 = 1;
        int amount = 1;
        return new Object[][]{
                {clients1, start1, amount},
                {clients2, start2, amount}
        };
    }

    @Test(dataProvider = "forFindCorrectLimitClientsOnPage")
    public void testFindCorrectLimitClientsOnPage(List<User> users, int start, int amount) throws ServiceException {
        Assert.assertEquals(serviceFactory.getUserService().findLimitClients(start, amount), users);
    }

    @Test
    public void testFindCorrectClientAmount() throws ServiceException {
        Assert.assertEquals(serviceFactory.getUserService().findClientAmount(), clientAmount);
    }

    @DataProvider
    public Object[] forFindWrongClientsAmount() {
        int amount1 = 4;
        int amount2 = 3;
        int amount3 = 0;
        return new Object[]{ amount1, amount2, amount3};
    }

    @Test(dataProvider = "forFindWrongClientsAmount")
    public void testFindWrongClientAmount(int amount) throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getUserService().findClientAmount(), amount);
    }

    @DataProvider
    public Object[][] forFindCorrectClientPageAmount() {
        int clientsOnPage1 = 1;
        int clientsOnPage2 = 2;
        int pageAmount1 = 2;
        int pageAmount2 = 1;
        return new Object[][]{
                {clientsOnPage1, pageAmount1},
                {clientsOnPage2, pageAmount2}
        };
    }

    @Test(dataProvider = "forFindCorrectClientPageAmount")
    public void testFindCorrectClientPageAmount(int clientsOnPage, int pageAmount) throws ServiceException {
        Assert.assertEquals(serviceFactory.getUserService().findClientPageAmount(clientsOnPage), pageAmount);
    }

    @DataProvider
    public Object[][] forFindWrongClientPageAmount() {
        int clientsOnPage1 = 1;
        int clientsOnPage2 = 2;
        int pageAmount1 = 1;
        int pageAmount2 = 2;
        return new Object[][]{
                {clientsOnPage1, pageAmount1},
                {clientsOnPage2, pageAmount2}
        };
    }

    @Test(dataProvider = "forFindWrongClientPageAmount")
    public void testFindWrongClientPageAmount(int clientsOnPage, int pageAmount) throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getUserService().findClientPageAmount(clientsOnPage), pageAmount);
    }

    @Test
    public void testChangeName() {
    }

    @Test
    public void testChangeSurname() {
    }

    @Test
    public void testChangePatronymic() {
    }

    @Test
    public void testChangeAddress() {
    }

    @Test
    public void testChangePhone() {
    }

    @Test
    public void testChangeNote() {
    }

    @Test
    public void testChangeRole() {
    }

    @Test
    public void testDeleteUser() {
    }





    @Test
    public void testAddUser() {
    }
}