package by.epam.composite.service.impl;

import by.epam.composite.domain.Component;
import by.epam.composite.service.parser.ChainTextParser;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ParagraphServiceImplTest {
    private ParagraphServiceImpl paragraphService = new ParagraphServiceImpl();

    @DataProvider
    public Object[][] forCorrectComponent(){
        Component component1 = ChainTextParser.parse("    Hello. It is my text. It is the first paragraph.\\n    Then. It is the second paragraph.\\n    Bye.\\n");
        Component component2  = ChainTextParser.parse("    Bye.\\n    Then. It is the second paragraph.\\n    Hello. It is my text. It is the first paragraph.\\n");
        Component component3 = ChainTextParser.parse("    Hello. It is my text.\\n    Bye.\\n");
        Component component4  = ChainTextParser.parse("    Bye.\\n    Hello. It is my text.\\n");
        return new Object[][]{
                {component1, component2},
                {component3, component4},
        };
    }

    @DataProvider
    public Object[][] forWrongComponent(){
        Component component1 = ChainTextParser.parse("    Hello. It is my text. It is the first paragraph.\\n    Then. It is the second paragraph.\\n    Bye.\\n");
        Component component2  = ChainTextParser.parse("    Then. It is the second paragraph.\\n    Bye.\\n    Hello. It is my text. It is the first paragraph.\\n");
        Component component3 = ChainTextParser.parse("    Hello. It is my text.\\n    Bye.\\n");
        Component component4  = ChainTextParser.parse("    Hello. It is my text.\\n    Bye.\\n");
        return new Object[][]{
                {component1, component2},
                {component3, component4},
        };
    }

    @Test(dataProvider = "forCorrectComponent")
    public void testSortCorrectComponents(Component component1, Component component2) {
        Assert.assertEquals(paragraphService.sort(component1).operation(), component2.operation());
    }

    @Test(dataProvider = "forWrongComponent")
    public void testSortWrongComponents(Component component1, Component component2) {
        Assert.assertNotEquals(paragraphService.sort(component1).operation(), component2.operation());
    }
}