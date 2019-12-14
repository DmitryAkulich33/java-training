package by.epam.nextdate.controller;

import by.epam.nextdate.domain.Date;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class NextDateCommandTest {
    public NextDateCommand nextDateCommand = new NextDateCommand();
    public Date date;

    @Test
    public void testCalculateNextDateNumberOne() {
        date = new Date(31, 12, 2008);
        Assert.assertEquals(new Date(1, 1, 2009), nextDateCommand.calculateNextDate(date));
    }

    @Test
    public void testCalculateNextDateNumberTwo() {
        date = new Date(31, 12, 2019);
        Assert.assertEquals(new Date(1, 1, 2020), nextDateCommand.calculateNextDate(date));
    }

    @Test
    public void testCalculateNextDateNumberThree() {
        date = new Date(28, 2, 2008);
        Assert.assertEquals(new Date(29, 2, 2008), nextDateCommand.calculateNextDate(date));
    }

    @Test
    public void testCalculateNextDateNumberFour() {
        date = new Date(29, 2, 2008);
        Assert.assertEquals(new Date(1, 3, 2008), nextDateCommand.calculateNextDate(date));
    }

    @Test
    public void testCalculateNextDateNumberFive() {
        date = new Date(28, 2, 2019);
        Assert.assertEquals(new Date(1, 3, 2019), nextDateCommand.calculateNextDate(date));
    }

    @Test
    public void testCalculateNextDateNumberSix() {
        date = new Date(31, 10, 2000);
        Assert.assertEquals(new Date(1, 11, 2000), nextDateCommand.calculateNextDate(date));
    }

    @Test
    public void testCalculateNextDateNumberSeven() {
        date = new Date(11, 12, 2000);
        Assert.assertEquals(new Date(12, 12, 2000), nextDateCommand.calculateNextDate(date));
    }
}