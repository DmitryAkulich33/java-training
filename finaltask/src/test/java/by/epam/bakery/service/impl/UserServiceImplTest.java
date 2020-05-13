package by.epam.bakery.service.impl;

import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.LoginIsNotFreeException;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.testng.Assert.*;

public class UserServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

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
        int clientAmount = 2;
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

    @DataProvider
    public Object[][] forChangeName() {
        User user1 = new User(3, "user1", "user1", 3, "Ivanov", "Petr", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        String newName1 = "Petr";
        String newName2 = "Ivan";
        String id = "3";
        return new Object[][]{
                {user1, newName1, id},
                {user2, newName2, id}
        };
    }

    @Test(priority = 1, dataProvider = "forChangeName")
    public void testChangeName(User user, String newName, String userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changeName(newName, Integer.parseInt(userId));
        Assert.assertEquals(serviceFactory.getUserService().findClientById(userId), user);
    }

    @DataProvider
    public Object[][] forChangeNameThrowValidatorException() {
        String newName1 = "1Petr";
        String newNAme2 = "ivan";
        String newNAme3 = "";
        int id = 3;
        return new Object[][]{
                {newName1, id},
                {newNAme2, id},
                {newNAme3, id}
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangeNameThrowValidatorException")
    public void testChangeNameThrowValidatorException(String newName, int userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changeName(newName, userId);
    }

    @DataProvider
    public Object[][] forChangeSurname() {
        User user1 = new User(3, "user1", "user1", 3, "Petrov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        String newSurname1 = "Petrov";
        String newSurname2 = "Ivanov";
        String id = "3";
        return new Object[][]{
                {user1, newSurname1, id},
                {user2, newSurname2, id}
        };
    }

    @Test(priority = 2, dataProvider = "forChangeSurname")
    public void testChangeSurname(User user, String newSurname, String userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changeSurname(newSurname, Integer.parseInt(userId));
        Assert.assertEquals(serviceFactory.getUserService().findClientById(userId), user);
    }

    @DataProvider
    public Object[][] forChangeSurnameThrowValidatorException() {
        String newSurname1 = "1Petrov";
        String newSurname2= "Ivano v";
        String newSurname3 = "";
        int id = 3;
        return new Object[][]{
                {newSurname1, id},
                {newSurname2, id},
                {newSurname3, id}
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangeSurnameThrowValidatorException")
    public void testChangeSurnameThrowValidatorException(String newSurname, int userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changeSurname(newSurname, userId);
    }

    @DataProvider
    public Object[][] forChangePatronymic() {
        User user1 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Petrovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        String newPatronymic1 = "Petrovich";
        String newPatronymic2 = "Ivanovich";
        String id = "3";
        return new Object[][]{
                {user1, newPatronymic1, id},
                {user2, newPatronymic2, id}
        };
    }

    @Test(priority = 3, dataProvider = "forChangePatronymic")
    public void testChangePatronymic(User user, String newPatronymic, String userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changePatronymic(newPatronymic, Integer.parseInt(userId));
        Assert.assertEquals(serviceFactory.getUserService().findClientById(userId), user);
    }

    @DataProvider
    public Object[][] forChangePatronymicThrowValidatorException() {
        String newPatronymic1 = "1Petrovich";
        String newPatronymic2= "Ivanovi ch";
        String newPatronymic3 = "";
        int id = 3;
        return new Object[][]{
                {newPatronymic1, id},
                {newPatronymic2, id},
                {newPatronymic3, id}
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangePatronymicThrowValidatorException")
    public void testChangePatronymicThrowValidatorException(String newPatronymic, int userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changePatronymic(newPatronymic, userId);
    }

    @DataProvider
    public Object[][] forChangeAddress() {
        User user1 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 229, 44 Lubimova St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        String newAddress1 = "Apt 229, 44 Lubimova St, Minsk";
        String newAddress2 = "Apt 18, 44 Rafieva St, Minsk";
        String id = "3";
        return new Object[][]{
                {user1, newAddress1, id},
                {user2, newAddress2, id}
        };
    }

    @Test(priority = 4, dataProvider = "forChangeAddress")
    public void testChangeAddress(User user, String newAddress, String userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changeAddress(newAddress, Integer.parseInt(userId));
        Assert.assertEquals(serviceFactory.getUserService().findClientById(userId), user);
    }

    @DataProvider
    public Object[][] forChangeAddressThrowValidatorException() {
        String newAddress1 = "1two";
        String newAddress2 = "dom";
        String newAddress3 = "";
        int id = 3;
        return new Object[][]{
                {newAddress1, id},
                {newAddress2, id},
                {newAddress3, id}
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangeAddressThrowValidatorException")
    public void testChangeAddressThrowValidatorException(String newAddress, int userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changeAddress(newAddress, userId);
    }

    @DataProvider
    public Object[][] forChangePhone() {
        User user1 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-044-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        String newPhone1 = "8-044-743-45-46";
        String newPhone2 = "8-029-743-45-46";
        String id = "3";
        return new Object[][]{
                {user1, newPhone1, id},
                {user2, newPhone2, id}
        };
    }

    @Test(priority = 5, dataProvider = "forChangePhone")
    public void testChangePhone(User user, String newPhone, String userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changePhone(newPhone, Integer.parseInt(userId));
        Assert.assertEquals(serviceFactory.getUserService().findClientById(userId), user);
    }

    @DataProvider
    public Object[][] forChangePhoneThrowValidatorException() {
        String newPhone1 = "8044-5646130";
        String newPhone2 = "8-44-564-61-30";
        String newPhone3 = "telephone";
        String newPhone4 = "";
        int id = 3;
        return new Object[][]{
                {newPhone1, id},
                {newPhone2, id},
                {newPhone3, id},
                {newPhone4, id}
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangePhoneThrowValidatorException")
    public void testChangePhoneThrowValidatorException(String newPhone, int userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changePhone(newPhone, userId);
    }

    @DataProvider
    public Object[][] forChangeNote() {
        User user1 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "There are enough parking spaces in the yard");
        User user2 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        String newNote1 = "There are enough parking spaces in the yard";
        String newNote2 = "In the yard problems with parking spaces";
        String id = "3";
        return new Object[][]{
                {user1, newNote1, id},
                {user2, newNote2, id}
        };
    }

    @Test(priority = 6, dataProvider = "forChangeNote")
    public void testChangeNote(User user, String newNote, String userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changeNote(newNote, Integer.parseInt(userId));
        Assert.assertEquals(serviceFactory.getUserService().findClientById(userId), user);
    }




    @DataProvider
    public Object[][] forChangeRole() {
        User user1 = new User(3, "user1", "user1", 2, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        User user2 = new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces");
        String newRole1 = "2";
        String newRole2 = "3";
        String id = "3";
        String login = "user1";
        String password = "user1";
        return new Object[][]{
                {user1, newRole1, id, login, password},
                {user2, newRole2, id, login, password}
        };
    }

    @Test(priority = 7, dataProvider = "forChangeRole")
    public void testChangeRole(User user, String newRole, String userId, String login, String password) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changeRole(newRole, Integer.parseInt(userId));
        Assert.assertEquals(serviceFactory.getUserService().login(login, password), user);
    }

    @DataProvider
    public Object[][] forChangeRoleThrowValidatorException() {
        String newRole1 = "0";
        String newRole2 = "4";
        String newRole3 = "role";
        String newRole4 = "";
        int id = 3;
        return new Object[][]{
                {newRole1, id},
                {newRole2, id},
                {newRole3, id},
                {newRole4, id}
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangeRoleThrowValidatorException")
    public void testChangeRoleThrowValidatorException(String newRole, int userId) throws ServiceException, ValidatorException {
        serviceFactory.getUserService().changeRole(newRole, userId);
    }

    @DataProvider
    public Object[][] forDeleteUser() {
        List<User> users1 = new ArrayList<>(Arrays.asList(new User(1, "admin", "admin", 1, "Akulich", "Dmitry", "Viktorovich", "Apt 229, 33 Lubimova St, Minsk", "8-044-564-61-30", "admin"),
                new User(2, "courier1", "courier1", 2, "Aleksievich", "Aleksey", "Alekseevich", "Apt 110, 31 Lubimova St, Minsk",
                        "8-029-165-61-30", "courier"),
                new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces")));
        List<User> users2 = new ArrayList<>(Arrays.asList(new User(1, "admin", "admin", 1, "Akulich", "Dmitry", "Viktorovich", "Apt 229, 33 Lubimova St, Minsk", "8-044-564-61-30", "admin"),
                new User(2, "courier1", "courier1", 2, "Aleksievich", "Aleksey", "Alekseevich", "Apt 110, 31 Lubimova St, Minsk",
                        "8-029-165-61-30", "courier")));
        int start = 0;
        int amount = 4;
        int id1 = 4;
        int id2 = 3;
        return new Object[][]{
                {users1, id1, start, amount},
                {users2, id2, start, amount}
        };
    }

    @Test(priority = 8, dataProvider = "forDeleteUser")
    public void testDeleteUser(List<User> users, int userId, int start, int amount) throws ServiceException {
        serviceFactory.getUserService().deleteUser(userId);
        Assert.assertEquals(serviceFactory.getUserService().findLimitUser(start, amount), users);
    }

    @DataProvider
    public Object[][] forAddUser() {
        List<User> users1 = new ArrayList<>(Arrays.asList(new User(1, "admin", "admin", 1, "Akulich", "Dmitry", "Viktorovich", "Apt 229, 33 Lubimova St, Minsk", "8-044-564-61-30", "admin"),
                new User(2, "courier1", "courier1", 2, "Aleksievich", "Aleksey", "Alekseevich", "Apt 110, 31 Lubimova St, Minsk",
                        "8-029-165-61-30", "courier"),
                new User(5, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces")));
        List<User> users2 = new ArrayList<>(Arrays.asList(new User(1, "admin", "admin", 1, "Akulich", "Dmitry", "Viktorovich", "Apt 229, 33 Lubimova St, Minsk", "8-044-564-61-30", "admin"),
                new User(2, "courier1", "courier1", 2, "Aleksievich", "Aleksey", "Alekseevich", "Apt 110, 31 Lubimova St, Minsk",
                        "8-029-165-61-30", "courier"),
                new User(5, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"),
                new User(6, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard")));
        int start = 0;
        int amount = 4;
        String login1 = "user1";
        String login2 = "user2";
        String password1 = "user1";
        String password2 = "user2";
        String role1 = "3";
        String role2 = "3";
        String surname1 = "Ivanov";
        String surname2 = "Petrov";
        String name1 = "Ivan";
        String name2 = "Petr";
        String patronymic1 = "Ivanovich";
        String patronymic2 = "Petrovich";
        String address1 = "Apt 18, 44 Rafieva St, Minsk";
        String address2 = "Apt 45, 17 Kazinca St, Minsk";
        String phone1 = "8-029-743-45-46";
        String phone2 = "8-044-573-76-40";
        String note1 = "In the yard problems with parking spaces";
        String note2 = "There are enough parking spaces in the yard";
        double total = 0.0;
        return new Object[][]{
                {users1, start, amount, login1, password1, role1, surname1, name1, patronymic1, address1, phone1, note1, total},
                {users2, start, amount, login2, password2, role2, surname2, name2, patronymic2, address2, phone2, note2, total}
        };
    }

    @Test(priority = 9, dataProvider = "forAddUser")
    public void testAddUser(List<User> users, int start, int amount, String login, String password, String role, String surname,
                            String name, String patronymic, String address, String phone, String note, double total) throws ValidatorException, ServiceException, LoginIsNotFreeException {
        serviceFactory.getUserService().addUser(login, password, role, surname, name, patronymic, address, phone, note, total);
        Assert.assertEquals(serviceFactory.getUserService().findLimitUser(start, amount), users);
    }

    @DataProvider
    public Object[][] forAddUserThrowValidatorException() {
        String login1 = "юзер1";
        String login2 = "u ser2";
        String password1 = "юзер 1";
        String password2 = "user 2";
        String role1 = "0";
        String role2 = "5";
        String surname1 = "";
        String surname2 = "petrov";
        String name1 = "Ivan";
        String name2 = "Petr";
        String patronymic1 = "ivanovich";
        String patronymic2 = "петрович";
        String address1 = "Min";
        String address2 = "45";
        String phone1 = "8-029743-45-46";
        String phone2 = "8-44-573-76-40";
        String note1 = "In the yard problems with parking spaces";
        String note2 = "There are enough parking spaces in the yard";
        double total = 0.0;
        return new Object[][]{
                {login1, password1, role1, surname1, name1, patronymic1, address1, phone1, note1, total},
                {login2, password2, role2, surname2, name2, patronymic2, address2, phone2, note2, total}
        };
    }

    @Test(dataProvider = "forAddUserThrowValidatorException", expectedExceptions = ValidatorException.class)
    public void testAddUserThrowValidatorException(String login, String password, String role, String surname, String name, String patronymic, String address,
                                                   String phone, String note, double total) throws ValidatorException, ServiceException, LoginIsNotFreeException {
        serviceFactory.getUserService().addUser(login, password, role, surname, name, patronymic, address, phone, note, total);
    }

    @DataProvider
    public Object[][] forAddUserThrowLoginIsNotFreeException() {
        String login1 = "user1";
        String login2 = "user2";
        String password1 = "user1";
        String password2 = "user2";
        String role1 = "3";
        String role2 = "3";
        String surname1 = "Ivanov";
        String surname2 = "Petrov";
        String name1 = "Ivan";
        String name2 = "Petr";
        String patronymic1 = "Ivanovich";
        String patronymic2 = "Petrovich";
        String address1 = "Apt 18, 44 Rafieva St, Minsk";
        String address2 = "Apt 45, 17 Kazinca St, Minsk";
        String phone1 = "8-029-743-45-46";
        String phone2 = "8-044-573-76-40";
        String note1 = "In the yard problems with parking spaces";
        String note2 = "There are enough parking spaces in the yard";
        double total = 0.0;
        return new Object[][]{
                {login1, password1, role1, surname1, name1, patronymic1, address1, phone1, note1, total},
                {login2, password2, role2, surname2, name2, patronymic2, address2, phone2, note2, total}
        };
    }

    @Test(priority = 10, dataProvider = "forAddUserThrowLoginIsNotFreeException", expectedExceptions = LoginIsNotFreeException.class)
    public void testAddUserThrowLoginIsNotFreeException(String login, String password, String role, String surname, String name, String patronymic, String address,
                                                   String phone, String note, double total) throws ValidatorException, ServiceException, LoginIsNotFreeException {
        serviceFactory.getUserService().addUser(login, password, role, surname, name, patronymic, address, phone, note, total);
    }

    @AfterTest
    void tearDown() throws SQLException, IOException {
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        String mysqlUrl = "jdbc:mysql://localhost:3306/test_bakery_db?serverTimezone=Europe/Minsk";
        Connection con = DriverManager.getConnection(mysqlUrl, "root", "5646130");
        ScriptRunner sr = new ScriptRunner(con);
        Reader reader = new BufferedReader(new FileReader("src/test/resources/sql/allScripts.sql"));
        sr.runScript(reader);
        con.close();
        reader.close();
        sr.closeConnection();
    }
}