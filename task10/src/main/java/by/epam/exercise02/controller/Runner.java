package by.epam.exercise02.controller;

import by.epam.exercise02.domain.Constants;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.view.Viewer;

public class Runner {
    public static void main(String[] args) {
        Viewer viewer = new Viewer();
        Controller controller = new Controller();

        Shop shop = controller.createShop(Constants.SHOP_NAME, Constants.LIST_FOR_SALE_PATH);
        if (shop != null) {
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
