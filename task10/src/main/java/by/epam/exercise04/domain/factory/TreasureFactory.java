package by.epam.exercise04.domain.factory;

import by.epam.exercise04.domain.*;

public class TreasureFactory {
    public Treasure getCurrentTreasure(String[] lineValues){
        TreasureType type = TreasureType.valueOf(lineValues[0].toUpperCase());
        Treasure treasure = null;
        switch (type){
            case COIN:
                String coinName = lineValues[0];
                int coinCost = Integer.parseInt(lineValues[1]);
                String coinMaterial = lineValues[2];
                int coinYear = Integer.parseInt(lineValues[3]);
                treasure = new Coin(coinName, coinCost, coinMaterial, coinYear);
                break;
            case RING:
                String ringName = lineValues[0];
                int ringCost = Integer.parseInt(lineValues[1]);
                String ringMaterial = lineValues[2];
                int ringSize = Integer.parseInt(lineValues[3]);
                treasure = new Ring(ringName, ringCost, ringMaterial, ringSize);
                break;
            case NECKLACE:
                String necklaceName = lineValues[0];
                int necklaceCost = Integer.parseInt(lineValues[1]);
                String necklaceMaterial = lineValues[2];
                int necklaceLength = Integer.parseInt(lineValues[3]);
                treasure = new Necklace(necklaceName, necklaceCost, necklaceMaterial, necklaceLength);
        }
        return treasure;
    }
}
