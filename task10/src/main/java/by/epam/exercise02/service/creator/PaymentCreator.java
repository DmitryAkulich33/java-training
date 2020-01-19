package by.epam.exercise02.service.creator;

import by.epam.exercise02.domain.Payment;
import by.epam.exercise02.domain.Product;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.domain.ShoppingList;
import by.epam.exercise02.service.exception.WrongProductsToBuyException;

import java.util.ArrayList;
import java.util.List;

public class PaymentCreator {

    public Payment createPayment(String name, Shop shop, ShoppingList shoppingList) throws WrongProductsToBuyException {
        Payment payment = new Payment();
        List<Product> products = findProductList(shop, shoppingList);
        payment.setBasket(payment.new Basket(products));
        int cost = findCost(payment);
        payment.setCost(cost);
        payment.setName(name);
        return payment;
    }

    public List<Product> findProductList(Shop shop, ShoppingList shoppingList) throws WrongProductsToBuyException {
        List<Product> productsToBuy = new ArrayList<>();
        for (String line : shoppingList.getShoppingList()) {
            boolean flag = false;
            for (Product product : shop.getProducts()) {
                if (line.equalsIgnoreCase(product.getProductName())) {
                    productsToBuy.add(product);
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                throw new WrongProductsToBuyException("Wrong names of products.");
            }
        }
        return productsToBuy;
    }

    public int findCost(Payment payment) {
        int cost = 0;
        for (Product product : payment.getBasket().getProducts()) {
            cost = cost + product.getProductCost();
        }
        return cost;
    }
}
