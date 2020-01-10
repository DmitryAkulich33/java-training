package by.epam.exercise02.service;


import by.epam.exercise02.dao.LinesReader;
import by.epam.exercise02.dao.exception.StreamNotReadingException;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.service.exception.NoProductsForSaleException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopCreator {
    public Shop createShop(String name, String path)throws NoProductsForSaleException, StreamNotReadingException{
        return new Shop(name, createProductListForSale(path));
    }

    public Map<String, Integer> createProductListForSale(String path) throws NoProductsForSaleException,
            StreamNotReadingException {
        LinesReader linesReader = new LinesReader();
        List<String> linesFromFile = linesReader.createListForSaleFromFile(path);
        if(linesFromFile.isEmpty()){
            throw new NoProductsForSaleException("No products for sale");
        }
        Map<String, Integer> forSale = new HashMap<>();
        for (String line : linesFromFile) {
            String[] array = line.trim().split("\\s");
            String productName = array[0];
            int productCost = Integer.parseInt(array[1]);
            forSale.put(productName, productCost);
        }
        return forSale;
    }
}
