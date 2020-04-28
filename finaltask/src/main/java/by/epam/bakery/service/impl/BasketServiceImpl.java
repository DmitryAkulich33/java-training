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
    public void saveBasket(String userLogin, double total) throws ServiceException {
        log.debug("Service: saving basket started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketDao dao = helper.createBasketDao();
            dao.save(userLogin, total);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: saving basket finished.");
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

    @Override
    public void changeTotal(double newTotal, int basketId) throws ServiceException{
        log.debug("Service: changing total in basket started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketDao dao = helper.createBasketDao();
            dao.changeTotal(newTotal, basketId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: changing total in basket finished.");
    }
}
