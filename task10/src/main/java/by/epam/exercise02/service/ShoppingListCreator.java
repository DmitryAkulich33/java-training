package by.epam.exercise02.service;

import by.epam.exercise02.domain.ShoppingList;
import by.epam.exercise02.service.exception.NoProductsToBuyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShoppingListCreator {
    public ShoppingList createShoppingList(String ownerName, String lineFromConsole){
        if(lineFromConsole.isEmpty()){
            throw new NoProductsToBuyException("No products to buy");
        }
        String[] array = lineFromConsole.trim().split("\\s");
        List<String> shoppingList = new ArrayList<>(Arrays.asList(array));
        return new ShoppingList(ownerName, shoppingList);
    }
}
