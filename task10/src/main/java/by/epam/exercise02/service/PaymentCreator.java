package by.epam.exercise02.service;

import by.epam.exercise02.domain.Payment;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.domain.ShoppingList;
import by.epam.exercise02.service.exception.WrongProductsToBuyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaymentCreator {
    public Payment createPayment(String name, Shop shop, ShoppingList shoppingList) throws WrongProductsToBuyException{
        Payment payment = new Payment(name);
        int cost = 0;
        List<Payment.Product> list = new ArrayList<>();
        for(Map.Entry entry : shop.getForSale().entrySet()){
            for(String line : shoppingList.getShoppingList()){
                if(line.equalsIgnoreCase((String)entry.getKey())){
                    String productName = (String) entry.getKey();
                    int productCost = (int) entry.getValue();
                    Payment.Product product = payment.new Product(productName, productCost);
                    list.add(product);
                    cost = cost + productCost;
                }
            }
        }
        if(list.isEmpty()){
            throw new WrongProductsToBuyException("Wrong names of products");
        }
        payment.setCost(cost);
        payment.setProductsList(list);
        return payment;
    }
}
