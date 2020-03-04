package by.epam.xml.service.builder;

import by.epam.xml.domain.Client;
import by.epam.xml.domain.Order;
import by.epam.xml.domain.Pie;
import by.epam.xml.domain.StatusEnum;
import by.epam.xml.service.Director;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class DirectorTest {
    private String fileName1 = "src/test/resources/ordersTest1.xml";
    private String fileName2 = "src/test/resources/ordersTest2.xml";

    @DataProvider
    public Object[][] forCorrectOrders() {
        Set<Order> orders1 = new HashSet<>();
        orders1.add(new Order(1, StatusEnum.DELIVERED, new Client(1, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "+375 29 7434546", "In the yard problems with parking spaces"),
                new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander"), LocalDateTime.parse("2020-01-30T09:00"), LocalDateTime.parse("2020-01-30T12:30")));
        Set<Order> orders2 = new HashSet<>();
        orders2.add(new Order(1, StatusEnum.DELIVERED, new Client(1, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "+375 29 7434546", "In the yard problems with parking spaces"),
                new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander"), LocalDateTime.parse("2020-01-30T09:00"), LocalDateTime.parse("2020-01-30T12:30")));
        orders2.add(new Order(2, StatusEnum.DELIVERED, new Client(3, "Sidorov", "Sidr", "Sidorovich", "Apt 95, 27 Lubimova St, Minsk", "+375 44 5982331", "Near the house there are construction work"),
                new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint"), LocalDateTime.parse("2020-01-31T10:00"), LocalDateTime.parse("2020-01-31T12:30:00")));
        return new Object[][]{{orders1, fileName1},
                {orders2, fileName2}};
    }

    @DataProvider
    public Object[][] forWrongOrders() {
        Set<Order> orders1 = new HashSet<>();
        orders1.add(new Order(2, StatusEnum.DELIVERED, new Client(1, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "+375 29 7434546", "In the yard problems with parking spaces"),
                new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander"), LocalDateTime.parse("2020-01-30T09:00"), LocalDateTime.parse("2020-01-30T12:30")));
        Set<Order> orders2 = new HashSet<>();
        orders2.add(new Order(1, StatusEnum.DELIVERED, new Client(1, "Ivanov", "Ivan", "Ivanovich", "Apt 18, 44 Rafieva St, Minsk", "+375 29 7434546", "In the yard problems with parking spaces"),
                new Pie(1, "Belorussian", 1000, 24.00, "Signature dough, rustic potatoes, with cracklings, fried mushrooms, caraway seeds and coriander"), LocalDateTime.parse("2020-01-30T09:00"), LocalDateTime.parse("2020-01-30T12:30")));
        orders2.add(new Order(2, StatusEnum.UNDELIVERED, new Client(3, "Sidorov", "Sidr", "Sidorovich", "Apt 95, 27 Lubimova St, Minsk", "+375 44 5982331", "Near the house there are construction work"),
                new Pie(2, "Italian", 950, 22.00, "Signature dough, sunny lemon with vitamin zest and peppermint"), LocalDateTime.parse("2020-01-31T10:00"), LocalDateTime.parse("2020-01-31T12:30:00")));
        return new Object[][]{{orders1, fileName1},
                {orders2, fileName2}};
    }

    @Test(dataProvider = "forCorrectOrders")
    public void testDOMCorrectOrder(Set<Order> orders, String fileName) {
        Assert.assertEquals(Director.createOrders(new OrderDOMBuilder(), fileName), orders);
    }

    @Test(dataProvider = "forWrongOrders")
    public void testDOMWrongOrder(Set<Order> orders, String fileName) {
        Assert.assertNotEquals(Director.createOrders(new OrderDOMBuilder(), fileName), orders);
    }

    @Test(dataProvider = "forCorrectOrders")
    public void testSAXCorrectOrder(Set<Order> orders, String fileName) {
        Assert.assertEquals(Director.createOrders(new OrderSAXBuilder(), fileName), orders);
    }

    @Test(dataProvider = "forWrongOrders")
    public void testSAXWrongOrder(Set<Order> orders, String fileName) {
        Assert.assertNotEquals(Director.createOrders(new OrderSAXBuilder(), fileName), orders);
    }

    @Test(dataProvider = "forCorrectOrders")
    public void testStAXCorrectOrder(Set<Order> orders, String fileName) {
        Assert.assertEquals(Director.createOrders(new OrderStAXBuilder(), fileName), orders);
    }

    @Test(dataProvider = "forWrongOrders")
    public void testStAXWrongOrder(Set<Order> orders, String fileName) {
        Assert.assertNotEquals(Director.createOrders(new OrderStAXBuilder(), fileName), orders);
    }
}