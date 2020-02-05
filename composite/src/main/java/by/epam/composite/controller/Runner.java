package by.epam.composite.controller;


import by.epam.composite.dao.FileReaderDAOImpl;
import by.epam.composite.dao.FileWriterDAOImpl;
import by.epam.composite.dao.exception.FileNotReadingException;
import by.epam.composite.domain.Component;
import by.epam.composite.service.parser.ChainTextParser;

public class Runner {
    public static void main(String[] args) throws FileNotReadingException {
        FileReaderDAOImpl fileReaderDAO = new FileReaderDAOImpl();
        FileWriterDAOImpl fileWriterDAO = new FileWriterDAOImpl();
        String text = fileReaderDAO.read("src\\main\\resources\\text.txt");

        Component component = ChainTextParser.parse(text);
        System.out.println(component.getComponents().get(0));
        System.out.println(component.getComponents().get(0).getComponents().get(0));
        System.out.println(component.getComponents().get(0).getComponents().get(0).getComponents().get(6));
//        try {
//            fileWriterDAO.write(component,"src\\main\\resources\\text2.txt");
//        } catch (FileNotWritingException e) {
//            e.printStackTrace();
//        }

    }
}
