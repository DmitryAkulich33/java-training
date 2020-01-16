package by.epam.exercise04.service.impl;

import by.epam.exercise04.dao.TreasureReaderDAO;
import by.epam.exercise04.dao.exception.StreamNotReadingException;
import by.epam.exercise04.dao.factory.DAOFactory;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.domain.Treasure;
import by.epam.exercise04.domain.factory.TreasureFactory;
import by.epam.exercise04.service.DragonCaveService;
import by.epam.exercise04.service.exception.EmptyListException;
import by.epam.exercise04.service.exception.ServiceException;
import by.epam.exercise04.service.validator.LinesValidator;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DragonCaveServiceImpl implements DragonCaveService {
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private TreasureReaderDAO readerDAO = daoObjectFactory.getReaderDAO();
    private LinesValidator validator = new LinesValidator();
    private TreasureFactory treasureFactory = new TreasureFactory();

    public DragonCave createDragonCave(String path) throws ServiceException, EmptyListException{
        List<String> validLines = findValidLines(path);
        List<Treasure> treasures = findTreasureList(validLines);
        return new DragonCave(treasures);
    }

    public List<String> findValidLines(String pathFile) throws ServiceException, EmptyListException{
        List<String> linesFromFile;
        try {
            linesFromFile = readerDAO.readTreasureList(pathFile);
        } catch (StreamNotReadingException ex){
            throw new ServiceException(ex.getMessage(), ex);
        }
        List<String> validLines = linesFromFile.stream().filter(validator::isLineValid).collect(Collectors.toList());
        if(validLines.isEmpty()){
            throw new EmptyListException("The treasure list is empty.");
        }
        return validLines;
    }

    public List<Treasure> findTreasureList(List<String> lines){
        List<Treasure> treasures = new ArrayList<>();
        for(String line : lines){
            String[] valuesFromLine = line.trim().split("\\s+");
            treasures.add(treasureFactory.getCurrentTreasure(valuesFromLine));
        }
        return treasures;
    }
}
