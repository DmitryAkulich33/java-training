package by.epam.exercise04.service.impl;

import by.epam.exercise04.dao.TreasureReaderDAO;
import by.epam.exercise04.dao.exception.StreamNotReadingException;
import by.epam.exercise04.dao.factory.DAOFactory;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.service.DragonCaveService;
import by.epam.exercise04.service.exception.EmptyListException;
import by.epam.exercise04.service.exception.InvalidPathException;
import by.epam.exercise04.service.validator.LinesValidator;

import java.util.List;
import java.util.stream.Collectors;

public class DragonCaveServiceImpl implements DragonCaveService {
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private TreasureReaderDAO readerDAO = daoObjectFactory.getReaderDAO();
    private LinesValidator validator = new LinesValidator();

    public DragonCave createDragonCave(String path){
        return null;
    }

    public List<String> findValidLines(String pathFile) throws InvalidPathException, EmptyListException{
        List<String> linesFromFile = null;
        try {
            linesFromFile = readerDAO.readTreasureList(pathFile);
        } catch (StreamNotReadingException ex){
            throw new InvalidPathException(ex.getMessage());
        }
        List<String> validLines = linesFromFile.stream().filter(validator::isLineValid).collect(Collectors.toList());
        if(validLines.isEmpty()){
            throw new EmptyListException("The treasure list is empty.");
        }
        return validLines;
    }
}
