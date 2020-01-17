package by.epam.exercise02.service;

import by.epam.exercise02.dao.ProductsWriterDAO;
import by.epam.exercise02.dao.exception.StreamNotWritingException;
import by.epam.exercise02.dao.factory.DAOFactory;
import by.epam.exercise02.domain.Payment;
import by.epam.exercise02.domain.Product;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.domain.ShoppingList;
import by.epam.exercise02.service.comparator.DecreaseCostComparator;
import by.epam.exercise02.service.comparator.IncreaseCostComparator;
import by.epam.exercise02.service.creator.PaymentCreator;
import by.epam.exercise02.service.creator.ShoppingListCreator;
import by.epam.exercise02.service.exception.NoProductsToBuyException;
import by.epam.exercise02.service.exception.ServiceException;
import by.epam.exercise02.service.exception.WrongProductsToBuyException;

import java.util.List;

public class PaymentService {
    private ShoppingListCreator shoppingListCreator = new ShoppingListCreator();
    private PaymentCreator paymentCreator = new PaymentCreator();
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private ProductsWriterDAO writerDAO = daoObjectFactory.getWriterDAO();

    public void createStandardBill(String pathIn, String lineFromConsole, Shop shop, String billOwner, String paymentName)
            throws NoProductsToBuyException, ServiceException, WrongProductsToBuyException {
        ShoppingList shoppingList = shoppingListCreator.createShoppingList(billOwner, lineFromConsole);
        Payment payment = paymentCreator.createPayment(paymentName, shop, shoppingList);
        try {
            writerDAO.writeBillInFile(payment, pathIn);
        } catch (StreamNotWritingException e) {
            throw new ServiceException(e);
        }
    }

    public void createBillIncreaseByCost(String pathIn, String lineFromConsole, Shop shop, String billOwner, String paymentName)
            throws NoProductsToBuyException, ServiceException, WrongProductsToBuyException {
        IncreaseCostComparator comparator = new IncreaseCostComparator();
        ShoppingList shoppingList = shoppingListCreator.createShoppingList(billOwner, lineFromConsole);
        Payment payment = paymentCreator.createPayment(paymentName, shop, shoppingList);
        List<Product> products = payment.getBasket().getProducts();
        products.sort(comparator);
        payment.getBasket().setProducts(products);
        try {
            writerDAO.writeBillInFile(payment, pathIn);
        } catch (StreamNotWritingException e) {
            throw new ServiceException(e);
        }
    }

    public void createBillDecreaseByCost(String pathIn, String lineFromConsole, Shop shop, String billOwner, String paymentName)
            throws NoProductsToBuyException, ServiceException, WrongProductsToBuyException {
        DecreaseCostComparator comparator = new DecreaseCostComparator();
        ShoppingList shoppingList = shoppingListCreator.createShoppingList(billOwner, lineFromConsole);
        Payment payment = paymentCreator.createPayment(paymentName, shop, shoppingList);
        List<Product> products = payment.getBasket().getProducts();
        products.sort(comparator);
        payment.getBasket().setProducts(products);
        try {
            writerDAO.writeBillInFile(payment, pathIn);
        } catch (StreamNotWritingException e) {
            throw new ServiceException(e);
        }
    }
}
