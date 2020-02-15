package by.epam.composite.service.impl;

import by.epam.composite.domain.Component;
import by.epam.composite.service.factory.ServiceFactory;
import by.epam.composite.service.parser.ChainTextParser;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class LexemeServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();
    private char toFind;

    @BeforeTest
    public void getValue() {
        toFind = 's';
    }

    @DataProvider
    public Object[][] forCorrectComponent() {
        Component component1 = ChainTextParser.parse("    Hello. It is the first paragraph.");
        String component2 = "    first is Hello. It paragraph. the";
        Component component3 = ChainTextParser.parse("    Hello. It is my text.");
        String component4 = "    is Hello. It my text.";
        return new Object[][]{
                {component1, component2},
                {component3, component4},
        };
    }

    @DataProvider
    public Object[][] forWrongComponent() {
        Component component1 = ChainTextParser.parse("    Hello. It is the first paragraph.");
        String component2 = "   is first Hello. It paragraph. the";
        Component component3 = ChainTextParser.parse("    Hello. It is my text.");
        String component4 = "   Hello. It is my text.";
        return new Object[][]{
                {component1, component2},
                {component3, component4},
        };
    }

    @Test(dataProvider = "forCorrectComponent")
    public void testSortCorrectComponents(Component component1, String component2) {
        Assert.assertEquals(serviceFactory.getLexemeService().sort(component1, toFind), component2);
    }

    @Test(dataProvider = "forWrongComponent")
    public void testSortWrongComponents(Component component1, String component2) {
        Assert.assertNotEquals(serviceFactory.getLexemeService().sort(component1, toFind), component2);
    }
}