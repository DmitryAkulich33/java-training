package by.epam.composite.controller;


import by.epam.composite.domain.Component;
import by.epam.composite.service.impl.ParagraphServiceImpl;
import by.epam.composite.service.impl.SentenceServiceImpl;
import by.epam.composite.service.impl.TextServiceImpl;
import by.epam.composite.service.exception.ServiceException;

public class Runner {
    public static void main(String[] args) throws  ServiceException {
        TextServiceImpl textService = new TextServiceImpl();
        ParagraphServiceImpl paragraphService = new ParagraphServiceImpl();
        SentenceServiceImpl sentenceService = new SentenceServiceImpl();
        String text = textService.readFromFile("src\\main\\resources\\text.txt");

        Component component1 = textService.divideIntoComponents(text);
        System.out.println(component1.operation());

        Component component2 = paragraphService.sort(component1);
        System.out.println(component2.operation());

        Component component3 = sentenceService.sort(component1);
        System.out.println(component3.operation());

//        try {
//            daoObjectFactory.getWriterDAO().write(component,"src\\main\\resources\\text2.txt");
//        } catch (FileNotWritingException e) {
//            e.printStackTrace();
//        }

    }
}
