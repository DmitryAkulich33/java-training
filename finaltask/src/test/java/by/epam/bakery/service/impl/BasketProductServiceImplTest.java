package by.epam.bakery.service.impl;

import by.epam.bakery.domain.Basket;
import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.domain.User;
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

public class BasketProductServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private List<BasketProduct> basketProducts = new ArrayList<>(Collections.singletonList(new BasketProduct(1, new Basket(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
            "In the yard problems with parking spaces"), 24.0), new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00)));

    @DataProvider
    public Object[][] forSaveBasketProduct() {
        List<BasketProduct> basketProducts1 = new ArrayList<>(Collections.singletonList(new BasketProduct(1, new Basket(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces"), 24.0), new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00)));
        List<BasketProduct> basketProducts2 = new ArrayList<>(Arrays.asList(new BasketProduct(1, new Basket(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), 46.0), new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"), 1, 24.00),
                new BasketProduct(2, new Basket(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), 46.0), new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"), 1, 22.00)));
        int basketId = 1;
        int pieId1 = 1;
        int pieId2 = 2;
        String amount = "1";
        double price1 = 24.00;
        double price2 = 22.00;
        double total1 = 24.00;
        double total2 = 46.00;
        return new Object[][]{
                {basketProducts1, basketId, pieId1, amount, price1, total1},
                {basketProducts2, basketId, pieId2, amount, price2, total2}
        };
    }

    @Test(dataProvider = "forSaveBasketProduct")
    public void testSaveBasketProduct(List<BasketProduct> products, int basketId, int pieId, String amount, double price,
                                      double newTotal) throws ServiceException, ValidatorException {
        serviceFactory.getBasketProductService().saveBasketProduct(basketId, pieId, amount, price, newTotal);
        Assert.assertEquals(serviceFactory.getBasketProductService().findProductByBasketId(basketId), products);
    }

    @DataProvider
    public Object[][] forSaveBasketProductThrowValidatorException() {
        int basketId = 1;
        int pieId1 = 1;
        int pieId2 = 2;
        String amount1 = "101";
        String amount2 = "";
        double price1 = 24.00;
        double price2 = 22.00;
        double total1 = 24.00;
        double total2 = 46.00;
        return new Object[][]{
                {basketId, pieId1, amount1, price1, total1},
                {basketId, pieId2, amount2, price2, total2}
        };
    }

    @Test(dataProvider = "forSaveBasketProductThrowValidatorException", expectedExceptions = ValidatorException.class)
    public void testSaveBasketProductThrowValidatorException(int basketId, int pieId, String amount, double price,
                                                             double newTotal) throws ServiceException, ValidatorException {
        serviceFactory.getBasketProductService().saveBasketProduct(basketId, pieId, amount, price, newTotal);
    }

    @Test(priority = 1)
    public void testDeleteBasketProductById() throws ServiceException {
        serviceFactory.getBasketProductService().deleteBasketProductById(2, 24, 1);
        Assert.assertEquals(serviceFactory.getBasketProductService().findProductByBasketId(1), basketProducts);
    }


    @Test(priority = 2)
    public void testClearBasket() throws ServiceException {
        serviceFactory.getBasketProductService().clearBasket(1, 0.0);
        Assert.assertEquals(serviceFactory.getBasketService().findBasketByUserLogin("user1").getTotal(), 0.0);
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