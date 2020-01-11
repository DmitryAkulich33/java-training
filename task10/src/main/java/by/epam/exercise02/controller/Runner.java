package by.epam.exercise02.controller;

import by.epam.exercise02.dao.exception.StreamNotReadingException;
import by.epam.exercise02.domain.Constants;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.service.creator.ShopCreator;
import by.epam.exercise02.service.exception.NoProductsForSaleException;
import by.epam.exercise02.view.Viewer;


public class Runner {
    public static void main(String[] args) {
        ShopCreator shopCreator = new ShopCreator();
        Viewer viewer = new Viewer();
        Controller controller = new Controller();
        Shop shop = null;
        try {
            shop = shopCreator.createShop(Constants.SHOP_NAME, Constants.LIST_FOR_SALE_PATH);
        } catch (NoProductsForSaleException e){
            System.out.println(e.getMessage());
        }
        if(!(shop == null)) {
            while (true) {
                viewer.printProductForSale(shop);
                String productNames = viewer.returnLine();
                viewer.printCommandMenu();
                String request = viewer.returnLine();
                if (request.equals("0")) {
                    return;
                } else {
                    viewer.printRequest(controller.executeTask(productNames, request, shop));
                }
                viewer.printNewAttempt();
            }
        }
    }
}
