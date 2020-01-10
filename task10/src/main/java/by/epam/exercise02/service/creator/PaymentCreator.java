package by.epam.exercise02.service.creator;

import by.epam.exercise02.domain.Payment;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.domain.ShoppingList;
import by.epam.exercise02.service.exception.WrongProductsToBuyException;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PaymentCreator {
    public Payment createPayment(String name, Shop shop, ShoppingList shoppingList) throws WrongProductsToBuyException {
        Payment payment = new Payment(name);
        List<Payment.Product> listToBuy = createListToBuy(shop, payment, shoppingList);
        int cost = findCost(listToBuy);
        payment.setProductsList(listToBuy);
        payment.setCost(cost);
        return payment;
    }

    public List<Payment.Product> createListToBuy(Shop shop, Payment payment, ShoppingList shoppingList) throws WrongProductsToBuyException {
        List<Payment.Product> listToBuy = new ArrayList<>();
        for (String line : shoppingList.getShoppingList()) {
            boolean flag = false;
            for (Map.Entry entry : shop.getForSale().entrySet()) {
                if (line.equalsIgnoreCase((String) entry.getKey())) {
                    String productName = (String) entry.getKey();
                    int productCost = (int) entry.getValue();
                    Payment.Product product = payment.new Product(productName, productCost);
                    listToBuy.add(product);
                    flag = true;
                }
            }
            if (!flag) {
                throw new WrongProductsToBuyException("Wrong names of products.");
            }
        }
        return listToBuy;
    }

    public int findCost(List<Payment.Product> listToBuy) {
        int cost = 0;
        for (Payment.Product product : listToBuy) {
            cost = cost + product.getProductCost();
        }
        return cost;
    }
}
