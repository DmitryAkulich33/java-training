package by.epam.bakery.service.impl;

import by.epam.bakery.domain.Pie;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.factory.ServiceFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

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

    //    @DataProvider
//    public Object[][] forCorrectPieList() {
//
//        return new Object[][]{
//                {component1, component2},
//                {component3, component4},
//        };
//    }
//    @BeforeTest
//    public void initList() {
//
//    }

//    @Test(dataProvider = "forCorrectPieList")
    @Test
    public void testCorrectPieList() {
        try {
            Assert.assertEquals(serviceFactory.getPieService().showAllPies(), correctPies);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testWrongPieList() {
        try {
            Assert.assertNotEquals(serviceFactory.getPieService().showAllPies(), wrongPies);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCorrectPieListSortedByPriceIncrease() {
        try {
            Assert.assertEquals(serviceFactory.getPieService().sortByPriceIncrease(), sortedByPriceIncrease);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWrongSortedByPriceIncrease() {
        try {
            Assert.assertNotEquals(serviceFactory.getPieService().sortByPriceIncrease(), correctPies);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCorrectPieListSortedByPriceReduce() {
        try {
            Assert.assertEquals(serviceFactory.getPieService().sortByPriceReduce(), sortedByPriceReduce);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testWrongSortedByPriceReduce() {
        try {
            Assert.assertNotEquals(serviceFactory.getPieService().sortByPriceReduce(), correctPies);
        } catch (ServiceException e) {
            e.printStackTrace();
        }
    }
    

    @Test
    public void testFindPieById() {
    }

    @Test
    public void testFindPieByName() {
    }

    @Test
    public void testDeletePie() {
    }

    @Test
    public void testAddPie() {
    }

    @Test
    public void testChangeName() {
    }

    @Test
    public void testChangePicture() {
    }

    @Test
    public void testChangeDescription() {
    }

    @Test
    public void testChangeWeight() {
    }

    @Test
    public void testChangePrice() {
    }

    @Test
    public void testGetSortPieList() {
    }
}