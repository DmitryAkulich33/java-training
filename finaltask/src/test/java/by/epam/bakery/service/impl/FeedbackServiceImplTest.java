package by.epam.bakery.service.impl;

import by.epam.bakery.domain.Feedback;
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
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class FeedbackServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    List<Feedback> allFeedbacks = new ArrayList<>(Arrays.asList(new Feedback(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                    "There are enough parking spaces in the yard"), LocalDateTime.parse("2020-04-09T12:00:00"), "It was delicious!"),
            new Feedback(2, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                    "In the yard problems with parking spaces"), LocalDateTime.parse("2020-04-08T11:00:00"), "It was good!"),
            new Feedback(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                    "In the yard problems with parking spaces"), LocalDateTime.parse("2020-04-05T10:00:00"), "It was bad!")));



    @DataProvider
    public Object[][] forFindCorrectLimitFeedbackOnPage() {
        List<Feedback> feedbacks1 = new ArrayList<>(Arrays.asList(new Feedback(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), LocalDateTime.parse("2020-04-09T12:00:00"), "It was delicious!"),
                new Feedback(2, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), LocalDateTime.parse("2020-04-08T11:00:00"), "It was good!")));
        List<Feedback> feedbacks2 = new ArrayList<>(Collections.singletonList(new Feedback(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces"), LocalDateTime.parse("2020-04-05T10:00:00"), "It was bad!")));
        int start1 = 0;
        int start2 = 2;
        int amount = 2;
        return new Object[][]{
                {feedbacks1, start1, amount},
                {feedbacks2, start2, amount}
        };
    }

    @Test(dataProvider = "forFindCorrectLimitFeedbackOnPage")
    public void testFindCorrectLimitFeedbackOnPage(List<Feedback> feedbacks, int start, int amount) throws ServiceException {
        Assert.assertEquals(serviceFactory.getFeedBackService().findLimitFeedback(start, amount), feedbacks);
    }

    @DataProvider
    public Object[][] forFindWrongLimitFeedbackOnPage() {
        List<Feedback> feedbacks1 = new ArrayList<>(Arrays.asList(new Feedback(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), LocalDateTime.parse("2020-04-09T12:00:00"), "It was delicious!"),
                new Feedback(2, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), LocalDateTime.parse("2020-04-08T11:00:00"), "It was good!")));
        List<Feedback> feedbacks2 = new ArrayList<>(Collections.singletonList(new Feedback(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                "In the yard problems with parking spaces"), LocalDateTime.parse("2020-04-05T10:00:00"), "It was bad!")));
        int start1 = 1;
        int start2 = 3;
        int amount = 2;
        return new Object[][]{
                {feedbacks1, start1, amount},
                {feedbacks2, start2, amount}
        };
    }

    @Test(dataProvider = "forFindWrongLimitFeedbackOnPage")
    public void testWrongFindWrongLimitFeedbackOnPage(List<Feedback> feedbacks, int start, int amount) throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getFeedBackService().findLimitFeedback(start, amount), feedbacks);
    }

    @DataProvider
    public Object[][] forFindCorrectFeedbackPageAmount() {
        int feedbacksOnPage1 = 1;
        int feedbacksOnPage2 = 2;
        int feedbacksOnPage3 = 3;
        int pageAmount1 = 3;
        int pageAmount2 = 2;
        int pageAmount3 = 1;
        return new Object[][]{
                {feedbacksOnPage1, pageAmount1},
                {feedbacksOnPage2, pageAmount2},
                {feedbacksOnPage3, pageAmount3}
        };
    }

    @Test(dataProvider = "forFindCorrectFeedbackPageAmount")
    public void testFindCorrectFeedbackPageAmount(int feedbacksOnPage, int pageAmount) throws ServiceException {
        Assert.assertEquals(serviceFactory.getFeedBackService().findFeedbackPageAmount(feedbacksOnPage), pageAmount);
    }

    @DataProvider
    public Object[][] forFindWrongFeedbackPageAmount() {
        int feedbacksOnPage1 = 1;
        int feedbacksOnPage2 = 2;
        int feedbacksOnPage3 = 3;
        int pageAmount1 = 1;
        int pageAmount2 = 1;
        int pageAmount3 = 2;
        return new Object[][]{
                {feedbacksOnPage1, pageAmount1},
                {feedbacksOnPage2, pageAmount2},
                {feedbacksOnPage3, pageAmount3}
        };
    }

    @Test(dataProvider = "forFindWrongFeedbackPageAmount")
    public void testFindWrongFeedbackPageAmount(int feedbacksOnPage, int pageAmount) throws ServiceException {
        Assert.assertNotEquals(serviceFactory.getFeedBackService().findFeedbackPageAmount(feedbacksOnPage), pageAmount);
    }

    @DataProvider
    public Object[][] forDeleteFeedback() {
        List<Feedback> feedbacks1 = new ArrayList<>(Arrays.asList(new Feedback(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), LocalDateTime.parse("2020-04-09T12:00:00"), "It was delicious!"),
                new Feedback(1, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), LocalDateTime.parse("2020-04-05T10:00:00"), "It was bad!")));
        List<Feedback> feedbacks2 = new ArrayList<>(Collections.singletonList(new Feedback(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                "There are enough parking spaces in the yard"), LocalDateTime.parse("2020-04-09T12:00:00"), "It was delicious!")));
        int id1 = 2;
        int id2 = 1;
        int start = 0;
        int amount = 3;
        return new Object[][]{
                {feedbacks1, id1, start, amount},
                {feedbacks2, id2, start, amount}
        };
    }

    @Test(priority = 1, dataProvider = "forDeleteFeedback")
    public void testDeleteFeedback(List<Feedback> feedbacks, int id, int start, int amount) throws ServiceException {
        serviceFactory.getFeedBackService().deleteFeedback(id);
        Assert.assertEquals(serviceFactory.getFeedBackService().findLimitFeedback(start, amount), feedbacks);
    }

    @DataProvider
    public Object[][] forSaveFeedback() {
        List<Feedback> feedbacks1 = new ArrayList<>(Arrays.asList(new Feedback(4, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), LocalDateTime.parse("2020-04-05T10:00:00"), "It was bad!"),
                new Feedback(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), LocalDateTime.parse("2020-04-09T12:00:00"), "It was delicious!")));
        List<Feedback> feedbacks2 = new ArrayList<>(Arrays.asList(new Feedback(5, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), LocalDateTime.parse("2020-04-05T09:00:00"), "It was good!"),
                new Feedback(4, new User(3, "user1", "user1", 3, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "8-029-743-45-46",
                        "In the yard problems with parking spaces"), LocalDateTime.parse("2020-04-05T10:00:00"), "It was bad!"),
                new Feedback(3, new User(4, "user2", "user2", 3, "Petrov", "Petr", "Petrovich", "Apt 45, 17 Kazinca St, Minsk", "8-044-573-76-40",
                        "There are enough parking spaces in the yard"), LocalDateTime.parse("2020-04-09T12:00:00"), "It was delicious!")));
        int userId = 3;
        LocalDateTime localDateTime1 = LocalDateTime.parse("2020-04-05T10:00:00");
        LocalDateTime localDateTime2 = LocalDateTime.parse("2020-04-05T09:00:00");
        String review1 = "It was bad!";
        String review2 = "It was good!";
        int start = 0;
        int amount = 3;
        return new Object[][]{
                {feedbacks1, userId, localDateTime1, review1, start, amount},
                {feedbacks2, userId, localDateTime2, review2, start, amount}
        };
    }

    @Test(priority = 2, dataProvider = "forSaveFeedback")
    public void testSaveFeedback(List<Feedback> feedbacks, int userId, LocalDateTime localDateTime, String review, int start, int amount) throws ServiceException, ValidatorException {
        serviceFactory.getFeedBackService().save(userId, localDateTime, review);
        Assert.assertEquals(serviceFactory.getFeedBackService().findLimitFeedback(start, amount), feedbacks);
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