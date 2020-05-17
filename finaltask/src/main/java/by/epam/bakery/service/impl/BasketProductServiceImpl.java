package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.BasketDao;
import by.epam.bakery.dao.api.BasketProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.service.api.BasketProductService;
import by.epam.bakery.service.exception.ServiceException;
import by.epam.bakery.service.exception.ValidatorException;
import by.epam.bakery.service.validator.PieDataValidator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

/**
 * Implementation of {@link BasketProductService} interface. Provides access to {@link by.epam.bakery.service.api.BasketProductService},
 * {@link by.epam.bakery.dao.exception.DaoException} and provides support for working with entity {@link BasketProduct}
 *
 * @see DaoHelper
 */
public class BasketProductServiceImpl implements BasketProductService {
    /**
     * Logger for this service
     */
    private static Logger log = LogManager.getLogger(BasketProductServiceImpl.class.getName());

    /**
     * Factory for Dao
     */
    private DaoHelperFactory daoHelperFactory;

    /**
     * Validator for this service
     */
    private PieDataValidator pieDataValidator = new PieDataValidator();

    /**
     * Constructor - creating a new object
     *
     * @param daoHelperFactory dao for this server
     */
    public BasketProductServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    /**
     * Save product to basket
     *
     * @param basketId basket's id
     * @param pieId    pie's id
     * @param amount   pie's amount
     * @param price    pie's price
     * @param newTotal basket's new total
     * @throws ServiceException   if there is an error on DAO layer
     * @throws ValidatorException if there are validation problems
     */
    @Override
    public void saveBasketProduct(int basketId, int pieId, String amount, double price, double newTotal) throws ServiceException, ValidatorException {
        log.debug("Service: saving basket product started.");
        if (!pieDataValidator.isPieAmountValid(amount)) {
            log.error("The number of pies is wrong");
            throw new ValidatorException("The number of pies is wrong");
        }
        int pieAmount = Integer.parseInt(amount);
        double cost = pieAmount * price;
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao basketProductDao = helper.createBasketProductDao();
            BasketDao basketDao = helper.createBasketDao();
            try {
                helper.startTransaction();
                basketProductDao.save(basketId, pieId, amount, cost);
                basketDao.changeTotal(newTotal, basketId);
                helper.endTransaction();
            } catch (DaoException ex) {
                helper.backTransaction();
                throw new ServiceException(ex);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: saving basket product finished.");
    }

    /**
     * Clear basket
     *
     * @param basketId basket's id
     * @param newTotal basket's new total
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public void clearBasket(int basketId, double newTotal) throws ServiceException {
        log.debug("Service: deleting basket product by basket id started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao basketProductDao = helper.createBasketProductDao();
            BasketDao basketDao = helper.createBasketDao();
            try {
                helper.startTransaction();
                basketProductDao.removeByBasketId(basketId);
                basketDao.changeTotal(newTotal, basketId);
                helper.endTransaction();
            } catch (DaoException ex) {
                helper.backTransaction();
                throw new ServiceException(ex);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: deleting basket product by basket id finished.");
    }

    /**
     * Delete product from basket by product from basket id
     *
     * @param basketProductId product's id
     * @param basketId        basket's id
     * @param newTotal        basket's new total
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public void deleteBasketProductById(int basketProductId, double newTotal, int basketId) throws ServiceException {
        log.debug("Service: deleting basket product by id started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao basketProductDao = helper.createBasketProductDao();
            BasketDao basketDao = helper.createBasketDao();
            try {
                helper.startTransaction();
                basketProductDao.removeById(basketProductId);
                basketDao.changeTotal(newTotal, basketId);
                helper.endTransaction();
            } catch (DaoException ex) {
                helper.backTransaction();
                throw new ServiceException(ex);
            }
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: deleting basket product by id finished.");
    }

    /**
     * Find all products by basket id
     *
     * @param basketId basket's id
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public List<BasketProduct> findProductByBasketId(int basketId) throws ServiceException {
        log.debug("Service: search product by basket id.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao dao = helper.createBasketProductDao();
            return dao.findByBasketId(basketId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
