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

public class BasketServiceImpl implements BasketService {
    private DaoHelperFactory daoHelperFactory;
    private static Logger log = LogManager.getLogger(BasketServiceImpl.class.getName());

    public BasketServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

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
