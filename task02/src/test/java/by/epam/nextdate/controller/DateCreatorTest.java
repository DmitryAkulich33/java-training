package by.epam.nextdate.controller;

import by.epam.nextdate.domain.Date;
import by.epam.nextdate.exception.WrongDateException;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class DateCreatorTest {
    public DateCreator dateCreator = new DateCreator();
    public Date date;


    @Test
    public void testDateNumberOne() {
        date = new Date(31, 12, 2008);
        Assert.assertEquals(date, dateCreator.create(Arrays.asList(31, 12, 2008)));
    }

    @Test
    public void testDateNumberTwo() {
        date = new Date(31, 12, 2019);
        Assert.assertEquals(date, dateCreator.create(Arrays.asList(31, 12, 2019)));
    }

    @Test(expectedExceptions = WrongDateException.class)
    public void testDateNumberThree() {
        date = dateCreator.create(Arrays.asList(-5, 12, 2019));
    }

    @Test(expectedExceptions = WrongDateException.class)
    public void testDateNumberFour() {
        date = dateCreator.create(Arrays.asList(12, -7, 2019));
    }

    @Test(expectedExceptions = WrongDateException.class)
    public void testDateNumberFive() {
        date = dateCreator.create(Arrays.asList(12, 2, -2019));
    }

    @Test(expectedExceptions = WrongDateException.class)
    public void testDateNumberSix() {
        date = dateCreator.create(Arrays.asList(0, 2, 2019));
    }

    @Test(expectedExceptions = WrongDateException.class)
    public void testDateNumberSeven() {
        date = dateCreator.create(Arrays.asList(1, 0, 2019));
    }

    @Test(expectedExceptions = WrongDateException.class)
    public void testDateNumberEight() {
        date = dateCreator.create(Arrays.asList(1, 2, 0));
    }

    @Test
    public void testDateNumberNine() {
        date = new Date(31, 12, 1);
        Assert.assertEquals(date, dateCreator.create(Arrays.asList(31, 12, 1)));
    }

    @Test
    public void testDateNumberTen() {
        date = new Date(31, 1, 2019);
        Assert.assertEquals(date, dateCreator.create(Arrays.asList(31, 1, 2019)));
    }

    @Test
    public void testDateNumberEleven() {
        date = new Date(30, 4, 2019);
        Assert.assertEquals(date, dateCreator.create(Arrays.asList(30, 4, 2019)));
    }

    @Test
    public void testDateNumberTwelve() {
        date = new Date(29, 2, 2000);
        Assert.assertEquals(date, dateCreator.create(Arrays.asList(29, 2, 2000)));
    }

    @Test
    public void testDateNumberThirteen() {
        date = new Date(29, 2, 2016);
        Assert.assertEquals(date, dateCreator.create(Arrays.asList(29, 2, 2016)));
    }

    @Test
    public void testDateNumberFourteen() {
        date = new Date(28, 2, 2019);
        Assert.assertEquals(date, dateCreator.create(Arrays.asList(28, 2, 2019)));
    }

    @Test
    public void testDateNumberFifthteen() {
        date = new Date(31, 5, 2019);
        Assert.assertEquals(date, dateCreator.create(Arrays.asList(31, 5, 2019)));
    }

    @Test
    public void testDateNumberSixteen() {
        date = new Date(31, 8, 2019);
        Assert.assertEquals(date, dateCreator.create(Arrays.asList(31, 8, 2019)));
    }

    @Test(expectedExceptions = WrongDateException.class)
    public void testDateNumberSeventeen() {
        date = dateCreator.create(Arrays.asList(29, 2, 2019));
    }


}