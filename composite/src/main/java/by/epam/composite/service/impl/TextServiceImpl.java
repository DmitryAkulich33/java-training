package by.epam.composite.service.impl;

import by.epam.composite.dao.FileReaderDAO;
import by.epam.composite.dao.FileWriterDAO;
import by.epam.composite.dao.exception.FileNotReadingException;
import by.epam.composite.dao.exception.FileNotWritingException;
import by.epam.composite.dao.factory.DAOFactory;
import by.epam.composite.domain.Component;
import by.epam.composite.service.TextService;
import by.epam.composite.service.exception.ServiceException;
import by.epam.composite.service.parser.ChainTextParser;

public class TextServiceImpl implements TextService {
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private FileReaderDAO readerDAO = daoObjectFactory.getReaderDAO();
    private FileWriterDAO writerDAO = daoObjectFactory.getWriterDAO();


    public String readFromFile(String path) throws ServiceException {
        String text;
        try {
            text = readerDAO.read(path);
        } catch (FileNotReadingException e) {
            throw new ServiceException(e);
        }
        return text;
    }

    public Component divideIntoComponents(String path) throws ServiceException {
        String text = readFromFile(path);
        return ChainTextParser.parse(text);
    }

    public void writeToFile(Component component, String path) throws ServiceException {
        try {
            writerDAO.write(component, path);
        } catch (FileNotWritingException e) {
            throw new ServiceException(e);
        }
    }

}
