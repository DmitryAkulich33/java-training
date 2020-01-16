package by.epam.exercise04.service.impl;

import by.epam.exercise04.dao.TreasureWriterDAO;
import by.epam.exercise04.dao.exception.StreamNotWritingException;
import by.epam.exercise04.dao.factory.DAOFactory;
import by.epam.exercise04.domain.DragonCave;
import by.epam.exercise04.domain.Treasure;
import by.epam.exercise04.service.TreasureService;
import by.epam.exercise04.service.exception.EmptyListException;
import by.epam.exercise04.service.exception.ServiceException;
import by.epam.exercise04.service.exception.WrongNumberException;

import java.util.ArrayList;
import java.util.List;

public class TreasureServiceImpl implements TreasureService {
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private TreasureWriterDAO writerDAO = daoObjectFactory.getWriterDAO();

    public Treasure getTheMostExpensiveTreasure(DragonCave dragonCave){
        List<Treasure> treasures = dragonCave.getTreasures();
        Treasure treasure = treasures.get(0);
        int size = treasures.size();
        for(int i = 1; i < size; i ++){
            if(treasure.getCost() < treasures.get(i).getCost()){
                treasure = treasures.get(i);
            }
        }
        return treasure;
    }

    public List<Treasure> selectTreasure(DragonCave dragonCave, int necessarySum) throws WrongNumberException{
        if(necessarySum <= 0){
            throw new WrongNumberException("Necessary sum is wrong.");
        }
        List<Treasure> treasures = dragonCave.getTreasures();
        List<Treasure> selectedTreasures = new ArrayList<>();
        int sum = 0;
        for(Treasure treasure : treasures){
            int cost = treasure.getCost();
            if(cost <= necessarySum) {
                sum = sum + cost;
                if (sum > necessarySum){
                    sum = sum - cost;
                    continue;
                }
                selectedTreasures.add(treasure);
                if(sum == necessarySum){
                    break;
                }
            }
        }
        return selectedTreasures;
    }

    public void deleteOneTreasure(Treasure delTreasure, DragonCave dragonCave){
        List<Treasure> treasures = dragonCave.getTreasures();
        int size = treasures.size();
        for(int i = 0; i < size; i++){
            if(treasures.get(i) == delTreasure){
                treasures.remove(i);
                break;
            }
        }
        dragonCave.setTreasures(treasures);
    }

    public void deleteTreasures(List<Treasure> delTreasures, DragonCave dragonCave) throws EmptyListException{
        if(delTreasures.isEmpty()){
            throw new EmptyListException("The treasure list is empty.");
        }
        List<Treasure> treasures = dragonCave.getTreasures();
        int delTreasuresSize = delTreasures.size();
        for(int i = 0; i < delTreasuresSize; i++){
            for(int j = 0; j < treasures.size(); j++){
                if(delTreasures.get(i) == treasures.get(j)){
                    treasures.remove(j);
                    break;
                }
            }
        }
        dragonCave.setTreasures(treasures);
    }
}
