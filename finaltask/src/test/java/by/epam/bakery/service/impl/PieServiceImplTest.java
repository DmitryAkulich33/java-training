package by.epam.bakery.service.impl;

import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PieServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private List<Pie> correctPies = new ArrayList<>(Arrays.asList(new Pie(1,"Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"),
            new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"),
            new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"),
            new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png")));
    private List<Pie> wrongPies = new ArrayList<>(Arrays.asList(new Pie(1,"Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"),
            new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"),
            new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg")));
    private List<Pie> sortedByPriceIncrease = new ArrayList<>(Arrays.asList(new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"),
            new Pie(1,"Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"),
            new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png"),
            new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg")));
    private List<Pie> sortedByPriceReduce = new ArrayList<>(Arrays.asList(new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"),
            new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png"),
            new Pie(1,"Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"),
            new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png")));
    private List<Pie> addPie = new ArrayList<>(Arrays.asList(new Pie(1,"Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png"),
            new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png"),
            new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg"),
            new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png"),
            new Pie(5, "Belgian", 900, 20.00, "Signature dough with delicate, fragrant raspberries", "image/Belg.png")));


    @Test
    public void testCorrectPieList() throws ServiceException {
        Assert.assertEquals(serviceFactory.getPieService().showAllPies(), correctPies);
    }

    @Test
    public void testWrongPieList() throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getPieService().showAllPies(), wrongPies);
    }

    @Test
    public void testCorrectPieListSortedByPriceIncrease() throws ServiceException {
        Assert.assertEquals(serviceFactory.getPieService().sortByPriceIncrease(), sortedByPriceIncrease);
    }

    @Test
    public void testWrongSortedByPriceIncrease() throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getPieService().sortByPriceIncrease(), correctPies);
    }

    @Test
    public void testCorrectPieListSortedByPriceReduce() throws ServiceException {
        Assert.assertEquals(serviceFactory.getPieService().sortByPriceReduce(), sortedByPriceReduce);
    }

    @Test
    public void testWrongSortedByPriceReduce() throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getPieService().sortByPriceReduce(), correctPies);
    }

    @DataProvider
    public Object[][] forCorrectFindPieById() {
        Pie pie1 = new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png");
        Pie pie2 = new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png");
        String id1 = "4";
        String id2 = "2";
        return new Object[][]{
                {pie1, id1},
                {pie2, id2},
        };
    }

    @Test(dataProvider = "forCorrectFindPieById")
    public void testFindCorrectPieById(Pie pie, String id) throws ServiceException, ValidatorException {
        Assert.assertEquals(serviceFactory.getPieService().findPieById(id), pie );
    }

    @DataProvider
    public Object[][] forWrongFindPieById() {
        Pie pie1 = new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png");
        Pie pie2 = new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png");
        String id1 = "3";
        String id2 = "1";
        return new Object[][]{
                {pie1, id1},
                {pie2, id2},
        };
    }

    @Test(dataProvider = "forCorrectFindPieById")
    public void testFindWrongPieById(Pie pie, String id) throws ServiceException, ValidatorException {
        Assert.assertEquals(serviceFactory.getPieService().findPieById(id), pie );
    }

    @DataProvider
    public Object[][] forCorrectFindPieByName() {
        Pie pie1 = new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png");
        Pie pie2 = new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png");
        String name1 = "French";
        String name2 = "Italian";
        return new Object[][]{
                {pie1, name1},
                {pie2, name2},
        };
    }

    @Test(dataProvider = "forCorrectFindPieByName")
    public void testCorrectFindPieByName(Pie pie, String name) throws ServiceException, ValidatorException {
        Assert.assertEquals(serviceFactory.getPieService().findPieByName(name), pie );
    }

    @DataProvider
    public Object[][] forWrongPieByName() {
        Pie pie1 = new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png");
        Pie pie2 = new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png");
        String name1 = "Belorussian";
        String name2 = "Deutsch";
        return new Object[][]{
                {pie1, name1},
                {pie2, name2},
        };
    }

    @Test(dataProvider = "forWrongPieByName")
    public void testWrongFindPieByName(Pie pie, String name) throws ServiceException, ValidatorException {
        Assert.assertNotEquals(serviceFactory.getPieService().findPieByName(name), pie );
    }

    @Test(priority = 1)
    public void testAddPie() throws ServiceException, ValidatorException, DaoException {
        serviceFactory.getPieService().addPie("Belgian", "900", "20.00", "Signature dough with delicate, fragrant raspberries", "image/Belg.png");
        Assert.assertEquals(serviceFactory.getPieService().showAllPies(), addPie);
    }

    @Test(priority = 2)
    public void testDeletePie() throws ServiceException {
        serviceFactory.getPieService().deletePie(5);
        Assert.assertEquals(serviceFactory.getPieService().showAllPies(), correctPies);
    }

    @DataProvider
    public Object[][] forCorrectSortPieList() {
        String value1 = "increase";
        String value2 = "reduce";
        return new Object[][]{
                {sortedByPriceIncrease, value1, value1, value2},
                {sortedByPriceReduce, value2 ,value1, value2},
                {correctPies, null, value1, value2},
        };
    }

    @Test(dataProvider = "forCorrectSortPieList")
    public void testGetCorrectSortPieList(List<Pie> pies, String correctValue, String increase, String reduce) throws ServiceException {
        Assert.assertEquals(serviceFactory.getPieService().getSortPieList(correctValue, increase, reduce), pies);

    }

    @DataProvider
    public Object[][] forWrongSortPieList() {
        String value1 = "increase";
        String value2 = "reduce";
        return new Object[][]{
                {sortedByPriceIncrease, value2, value1, value2},
                {sortedByPriceReduce, null ,value1, value2},
                {correctPies, value1, value1, value2},
        };
    }

    @Test(dataProvider = "forWrongSortPieList")
    public void testGetWrongSortPieList(List<Pie> pies, String correctValue, String increase, String reduce) throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getPieService().getSortPieList(correctValue, increase, reduce), pies);
    }

    @DataProvider
    public Object[][] forChangeName() {
        Pie pie1 = new Pie(1,"Russian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png");
        Pie pie2 = new Pie(1,"Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png");
        String name1 = "Russian";
        String name2 = "Belorussian";
        int id = 1;
        return new Object[][]{
                {name1, id, pie1},
                {name2, id, pie2},
        };
    }

    @Test(priority = 3, dataProvider = "forChangeName")
    public void testChangeName(String newName, int id, Pie pie) throws ServiceException, ValidatorException {
        serviceFactory.getPieService().changeName(newName, id);
        Assert.assertEquals(serviceFactory.getPieService().findPieByName(newName), pie);
    }

    @DataProvider
    public Object[][] forChangeNameThrowValidatorException() {
        String name1 = "aaa";
        String name2 = "Belorussian1";
        int id = 1;
        return new Object[][]{
                {name1, id},
                {name2, id},
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangeNameThrowValidatorException")
    public void testChangeNameThrowValidatorException(String newName, int id) throws ServiceException, ValidatorException {
        serviceFactory.getPieService().changeName(newName, id);
    }

    @DataProvider
    public Object[][] forChangePicture() {
        Pie pie1 = new Pie(1,"Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Italian.png");
        Pie pie2 = new Pie(1,"Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Belarus.png");
        String picture1 = "image/Italian.png";
        String picture2 = "image/Belarus.png";
        int id = 1;
        return new Object[][]{
                {picture1, id, pie1},
                {picture2, id, pie2},
        };
    }

    @Test(priority = 4, dataProvider = "forChangePicture")
    public void testChangePicture(String newPicture, int id, Pie pie) throws ServiceException, ValidatorException {
        serviceFactory.getPieService().changePicture(newPicture, id);
        Assert.assertEquals(serviceFactory.getPieService().findPieById(String.valueOf(id)), pie);
    }


    @DataProvider
    public Object[][] forChangeDescription() {
        Pie pie1 = new Pie(2, "Italian", 950, 22.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander", "image/Ital.png");
        Pie pie2 = new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint", "image/Ital.png");
        String description1 = "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander";
        String description2 = "Signature dough, sunny lemon with vitamin zest and peppermint";
        int id = 2;
        return new Object[][]{
                {description1, id, pie1},
                {description2, id, pie2},
        };
    }

    @Test(priority = 5, dataProvider = "forChangeDescription")
    public void testChangeDescription(String newDescription, int id, Pie pie) throws ServiceException, ValidatorException {
        serviceFactory.getPieService().changeDescription(newDescription, id);
        Assert.assertEquals(serviceFactory.getPieService().findPieById(String.valueOf(id)), pie);
    }


    @DataProvider
    public Object[][] forChangeWeightThrowValidatorException() {
        String name1 = "one";
        String name2 = "3555";
        int id = 1;
        return new Object[][]{
                {name1, id},
                {name2, id},
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangeWeightThrowValidatorException")
    public void testChangeWeightThrowValidatorException(String newWeight, int id) throws ServiceException, ValidatorException {
        serviceFactory.getPieService().changeWeight(newWeight, id);
    }

    @DataProvider
    public Object[][] forChangeWeight() {
        Pie pie1 = new Pie(3, "Deutsch", 900, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg");
        Pie pie2 = new Pie(3, "Deutsch", 1050, 26.00, "Signature dough, juicy flavored strawberries with ricotta", "image/Germ.jpg");
        String weight1 = "900";
        String weight2 = "1050";
        int id = 3;
        return new Object[][]{
                {weight1, id, pie1},
                {weight2, id, pie2},
        };
    }

    @Test(priority = 5, dataProvider = "forChangeWeight")
    public void testChangeWeight(String newWeight, int id, Pie pie) throws ServiceException, ValidatorException {
        serviceFactory.getPieService().changeWeight(newWeight, id);
        Assert.assertEquals(serviceFactory.getPieService().findPieById(String.valueOf(id)), pie);
    }

    @DataProvider
    public Object[][] forChangePriceThrowValidatorException() {
        String name1 = "0";
        String name2 = "one";
        int id = 1;
        return new Object[][]{
                {name1, id},
                {name2, id},
        };
    }

    @Test(expectedExceptions = ValidatorException.class, dataProvider = "forChangePriceThrowValidatorException")
    public void testChangePriceThrowValidatorException(String newPrice, int id) throws ServiceException, ValidatorException {
        serviceFactory.getPieService().changePrice(newPrice, id);
    }

    @DataProvider
    public Object[][] forChangePrice() {
        Pie pie1 =  new Pie(4, "French", 1000, 29.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png");
        Pie pie2 =  new Pie(4, "French", 1000, 25.00, "Signature dough, ripe spicy cherry with hints of clove", "image/france.png");
        String price1 = "29.00";
        String price2 = "25.00";
        int id = 4;
        return new Object[][]{
                {price1, id, pie1},
                {price2, id, pie2},
        };
    }

    @Test(priority = 5, dataProvider = "forChangePrice")
    public void testChangePrice(String newPrice, int id, Pie pie) throws ServiceException, ValidatorException {
        serviceFactory.getPieService().changePrice(newPrice, id);
        Assert.assertEquals(serviceFactory.getPieService().findPieById(String.valueOf(id)), pie);
    }

    @BeforeTest
    public void beforeTest() throws SQLException, IOException{
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