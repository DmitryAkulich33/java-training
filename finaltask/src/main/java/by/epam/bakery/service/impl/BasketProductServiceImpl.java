package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.BasketProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.BasketProduct;
import by.epam.bakery.service.api.BasketProductService;
import by.epam.bakery.service.exception.ServiceException;

import java.util.List;

public class BasketProductServiceImpl implements BasketProductService {
    private DaoHelperFactory daoHelperFactory;

    public BasketProductServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void saveBasketProduct(int basketId, int pieId, int amount, double cost) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao dao = helper.createBasketProductDao();
            dao.save(basketId, pieId, amount, cost);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteBasketProductByBasketId(int basketId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao dao = helper.createBasketProductDao();
            dao.removeByBasketId(basketId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public void deleteBasketProductById(int basketProductId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao dao = helper.createBasketProductDao();
            dao.removeById(basketProductId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<BasketProduct> findProductByBasketId(int basketId) throws ServiceException {
        try (DaoHelper helper = daoHelperFactory.create()) {
            BasketProductDao dao = helper.createBasketProductDao();
            return dao.findByBasketId(basketId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
