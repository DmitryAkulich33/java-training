package by.epam.composite.service.impl;

import by.epam.composite.service.exception.ServiceException;
import by.epam.composite.service.factory.ServiceFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class TextServiceImplTest {
    private ServiceFactory serviceFactory = ServiceFactory.getInstance();

    @DataProvider
    public Object[] forWrongPath(){
        String path1 = "src\\main\\resources\\composite\\task3.zxc";
        String path2 = "src\\main\\resources\\composite\\task323232332.zxc";

        return new Object[]{
                path1,
                path2,
        };
    }

    @Test(dataProvider = "forWrongPath", expectedExceptions = ServiceException.class)
    public void testReadFromFileException(String path) throws ServiceException {
        String text = serviceFactory.getTextService().readFromFile(path);
    }
}