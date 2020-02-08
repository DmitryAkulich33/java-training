package by.epam.composite.controller;


import by.epam.composite.dao.factory.DAOFactory;
import by.epam.composite.dao.exception.FileNotReadingException;
import by.epam.composite.domain.Component;
import by.epam.composite.domain.Text;
import by.epam.composite.service.ParagraphServiceImpl;
import by.epam.composite.service.TextServiceImpl;
import by.epam.composite.service.copier.ComponentCopy;
import by.epam.composite.service.exception.ServiceException;
import by.epam.composite.service.parser.ChainTextParser;

public class Runner {
    public static void main(String[] args) throws  ServiceException {
        TextServiceImpl textService = new TextServiceImpl();
        ParagraphServiceImpl paragraphService = new ParagraphServiceImpl();
        ComponentCopy componentCopy = new ComponentCopy();
        String text = textService.readFromFile("src\\main\\resources\\text.txt");

        Component component1 = textService.divideIntoComponents(text);
        System.out.println(component1.operation());

        Component component2 = paragraphService.sort(component1);
        System.out.println(component2.operation());

//        try {
//            daoObjectFactory.getWriterDAO().write(component,"src\\main\\resources\\text2.txt");
//        } catch (FileNotWritingException e) {
//            e.printStackTrace();
//        }

    }
}
