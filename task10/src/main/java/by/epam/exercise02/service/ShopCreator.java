package by.epam.exercise02.service;


import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.service.exception.NoProductsForSaleException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopCreator {
    public Shop createShop(String name, List<String> linesFromFile) throws NoProductsForSaleException{
        if(linesFromFile.isEmpty()){
            throw new NoProductsForSaleException("No products for sale");
        }
        Map<String, Integer> forSale = new HashMap<>();
        int length = linesFromFile.size();
        for(int i = 0; i < length; i ++){
            String[] array = linesFromFile.get(i).trim().split("\\s");
            String productName = array[0];
            int productCost = Integer.parseInt(array[1]);
            forSale.put(productName, productCost);
        }
        return new Shop(name, forSale);
    }
}
