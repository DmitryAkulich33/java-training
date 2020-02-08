package by.epam.composite.controller;


import by.epam.composite.dao.exception.FileNotWritingException;
import by.epam.composite.dao.factory.DAOFactory;
import by.epam.composite.dao.exception.FileNotReadingException;
import by.epam.composite.domain.Component;
import by.epam.composite.domain.TextComposite;
import by.epam.composite.service.parser.ChainTextParser;

public class Runner {
    public static void main(String[] args) throws FileNotReadingException {
        DAOFactory daoObjectFactory = DAOFactory.getInstance();

        String text = daoObjectFactory.getReaderDAO().read("src\\main\\resources\\text.txt");

//        Component component = ChainTextParser.parse(text);
        TextComposite textComposite = (TextComposite) ChainTextParser.parse(text);
        System.out.println(textComposite);
        System.out.println();

//        try {
//            daoObjectFactory.getWriterDAO().write(component,"src\\main\\resources\\text2.txt");
//        } catch (FileNotWritingException e) {
//            e.printStackTrace();
//        }

    }
}
