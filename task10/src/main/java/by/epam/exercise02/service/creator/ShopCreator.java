package by.epam.exercise02.service.creator;

import by.epam.exercise02.dao.ProductsReaderDAO;
import by.epam.exercise02.dao.exception.StreamNotReadingException;
import by.epam.exercise02.dao.factory.DAOFactory;
import by.epam.exercise02.domain.Product;
import by.epam.exercise02.domain.Shop;
import by.epam.exercise02.service.exception.NoProductsForSaleException;
import by.epam.exercise02.service.exception.ServiceException;
import by.epam.exercise02.service.validator.LinesValidator;

import java.util.ArrayList;
import java.util.List;

public class ShopCreator {
    private DAOFactory daoObjectFactory = DAOFactory.getInstance();
    private ProductsReaderDAO readerDAO = daoObjectFactory.getReaderDAO();

    public Shop createShop(String name, String path) throws NoProductsForSaleException {
        return new Shop(name, createProductListForSale(path));
    }

    public List<Product> createProductListForSale(String path) throws NoProductsForSaleException, ServiceException {
        List<Product> products = new ArrayList<>();
        List<String> linesFromFile;
        try {
            linesFromFile = readerDAO.createListForSaleFromFile(path);
        } catch (StreamNotReadingException e) {
            throw new ServiceException(e);
        }
        LinesValidator validator = new LinesValidator();
        for (String line : linesFromFile) {
            if (validator.isLineValid(line)) {
                products.add(getProduct(line));
            }
        }
        if(products.isEmpty()){
            throw new NoProductsForSaleException("No products for sale.");
        }
        return products;
    }

    public Product getProduct(String line) {
        String[] array = line.trim().split("\\s+");
        String productName = array[0];
        int productCost = Integer.parseInt(array[1]);
        return new Product(productName, productCost);
    }
}
