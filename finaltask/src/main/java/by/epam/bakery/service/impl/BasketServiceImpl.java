package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.BasketDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.Basket;
import by.epam.bakery.service.api.BasketService;
import by.epam.bakery.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Implementation of {@link BasketService} interface. Provides access to {@link by.epam.bakery.service.api.BasketService},
 * {@link by.epam.bakery.dao.exception.DaoException} and provides support for working with entity {@link Basket}
 *
 * @see DaoHelper
 */
public class BasketServiceImpl implements BasketService {
    /**
     * Factory for Dao
     */
    private DaoHelperFactory daoHelperFactory;

    /**
     * Logger for this service
     */
    private static Logger log = LogManager.getLogger(BasketServiceImpl.class.getName());

    /**
     * Constructor - creating a new object
     *
     * @param daoHelperFactory dao for this server
     */
    public BasketServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    /**
     * Find basket by user's login
     *
     * @param userLogin user's login
     * @return Basket
     * @throws ServiceException if there is an error on DAO layer
     */
    @Override
    public Basket findBasketByUserLogin (String userLogin) throws ServiceException{
        log.debug("Service: search basket by user login.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketDao dao = helper.createBasketDao();
            return dao.getBasketByUserLogin(userLogin);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
