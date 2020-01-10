package by.epam.exercise02.service;

import by.epam.exercise02.dao.LinesWriter;
import by.epam.exercise02.dao.exception.StreamNotReadingException;
import by.epam.exercise02.dao.exception.StreamNotWritingException;
import by.epam.exercise02.domain.Payment;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.domain.ShoppingList;
import by.epam.exercise02.service.comparator.DecreaseCostComparator;
import by.epam.exercise02.service.comparator.IncreaseCostComparator;
import by.epam.exercise02.service.creator.PaymentCreator;
import by.epam.exercise02.service.creator.ShopCreator;
import by.epam.exercise02.service.creator.ShoppingListCreator;
import by.epam.exercise02.service.exception.NoProductsForSaleException;
import by.epam.exercise02.service.exception.NoProductsToBuyException;
import by.epam.exercise02.service.exception.WrongProductsToBuyException;

import java.util.List;

public class PaymentService {
    private ShopCreator shopCreator = new ShopCreator();
    private ShoppingListCreator shoppingListCreator = new ShoppingListCreator();
    private PaymentCreator paymentCreator = new PaymentCreator();
    private LinesWriter linesWriter = new LinesWriter();

    public void createStandardBill(String pathIn, String lineFromConsole, Shop shop, String billOwner, String paymentName)
            throws NoProductsToBuyException, NoProductsForSaleException, WrongProductsToBuyException, StreamNotReadingException, StreamNotWritingException {
        ShoppingList shoppingList = shoppingListCreator.createShoppingList(billOwner, lineFromConsole);
        Payment payment = paymentCreator.createPayment(paymentName, shop, shoppingList);
        linesWriter.writeListToBuyInFile(payment, pathIn);
    }

    public void createBillIncreaseByCost(String pathIn, String lineFromConsole, Shop shop, String billOwner, String paymentName)
            throws NoProductsToBuyException, NoProductsForSaleException, WrongProductsToBuyException, StreamNotReadingException, StreamNotWritingException {
        IncreaseCostComparator comparator = new IncreaseCostComparator();
        ShoppingList shoppingList = shoppingListCreator.createShoppingList(billOwner, lineFromConsole);
        Payment payment = paymentCreator.createPayment(paymentName, shop, shoppingList);
        List<Payment.Product> products = payment.getProductsList();
        products.sort(comparator);
        payment.setProductsList(products);
        linesWriter.writeListToBuyInFile(payment, pathIn);
    }

    public void createBillDecreaseByCost(String pathIn, String lineFromConsole, Shop shop, String billOwner, String paymentName)
            throws NoProductsToBuyException, NoProductsForSaleException, WrongProductsToBuyException, StreamNotReadingException, StreamNotWritingException {
        DecreaseCostComparator comparator = new DecreaseCostComparator();
        ShoppingList shoppingList = shoppingListCreator.createShoppingList(billOwner, lineFromConsole);
        Payment payment = paymentCreator.createPayment(paymentName, shop, shoppingList);
        List<Payment.Product> products = payment.getProductsList();
        products.sort(comparator);
        payment.setProductsList(products);
        linesWriter.writeListToBuyInFile(payment, pathIn);
    }
}
