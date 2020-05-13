package by.epam.bakery.service.impl;

import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.User;
import by.epam.bakery.service.exception.ServiceException;
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

import static org.testng.Assert.*;

public class BasketServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @DataProvider
    public Object[][] forFindBasketByUserLogin() {
        Basket basket1 = new Basket(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces"), 0.0);
        Basket basket2 = new Basket(2, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                "There are enough parking spaces in the yard"), 0.0);
        String userLogin1 = "user1";
        String userLogin2 = "user2";

        return new Object[][]{
                {basket1, userLogin1},
                {basket2, userLogin2}
        };
    }

    @Test(dataProvider = "forFindBasketByUserLogin")
    public void testFindBasketByUserLogin(Basket basket, String userLogin) throws ServiceException {
        Assert.assertEquals(serviceFactory.getBasketService().findBasketByUserLogin(userLogin), basket);

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