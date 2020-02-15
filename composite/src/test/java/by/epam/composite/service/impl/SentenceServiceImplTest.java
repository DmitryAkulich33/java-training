package by.epam.composite.service.impl;

import by.epam.composite.domain.Component;
import by.epam.composite.service.factory.ServiceFactory;
import by.epam.composite.service.parser.ChainTextParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class SentenceServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @DataProvider
    public Object[][] forCorrectComponent() {
        Component component1 = ChainTextParser.parse("    Hello. It is my the second text. It is the first paragraph.\\n    Then. It is the second paragraph.\\n    Bye.\\n");
        Component component2 = ChainTextParser.parse("    Hello. It is my the text. second It is the first paragraph.\\n    Then. It is the second paragraph.\\n    Bye.\\n");
        Component component3 = ChainTextParser.parse("    Hello. This is my text.\\n    Bye.\\n");
        Component component4 = ChainTextParser.parse("    Hello. is my This text.\\n    Bye.\\n");
        return new Object[][]{
                {component1, component2},
                {component3, component4},
        };
    }

    @DataProvider
    public Object[][] forWrongComponent() {
        Component component1 = ChainTextParser.parse("    Hello. It is my the second text. It is the first paragraph.\\n    Then. It is the second paragraph.\\n    Bye.\\n");
        Component component2 = ChainTextParser.parse("    Hello. It is my the text. second  the It is first paragraph.\\n    Then. It is the second paragraph.\\n    Bye.\\n");
        Component component3 = ChainTextParser.parse("    Hello. This is my text.\\n    Bye.\\n");
        Component component4 = ChainTextParser.parse("    Hello. This is my text.\\n    Bye.\\n");
        return new Object[][]{
                {component1, component2},
                {component3, component4},
        };
    }

    @Test(dataProvider = "forCorrectComponent")
    public void testSortCorrectComponents(Component component1, Component component2) {
        Assert.assertEquals(serviceFactory.getSentenceService().sort(component1).operation(), component2.operation());
    }

    @Test(dataProvider = "forWrongComponent")
    public void testSortWrongComponents(Component component1, Component component2) {
        Assert.assertNotEquals(serviceFactory.getSentenceService().sort(component1).operation(), component2.operation());
    }
}