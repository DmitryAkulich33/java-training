package by.epam.exercise02.controller;

import by.epam.exercise02.domain.Constants;
import by.epam.exercise02.domain.Payment;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.domain.ShoppingList;
import by.epam.exercise02.service.PaymentCreator;
import by.epam.exercise02.service.ShopCreator;
import by.epam.exercise02.service.ShoppingListCreator;


public class Runner {
    public static void main(String[] args) {
        ShopCreator shopCreator = new ShopCreator();
        Shop shop = shopCreator.createShop(Constants.SHOP_NAME, Constants.LIST_FOR_SALE);
        System.out.println(shop);
        PaymentCreator paymentCreator = new PaymentCreator();
        ShoppingListCreator shoppingListCreator = new ShoppingListCreator();
        String line = "Water pork";
        ShoppingList shoppingList = shoppingListCreator.createShoppingList(Constants.CUSTOMER_NAME, line);
        Payment payment = paymentCreator.createPayment("001", shop, shoppingList);
        System.out.println(payment);
    }
}
