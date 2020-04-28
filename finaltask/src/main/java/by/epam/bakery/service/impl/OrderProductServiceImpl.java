package by.epam.bakery.service.impl;

import by.epam.bakery.dao.DaoHelper;
import by.epam.bakery.dao.DaoHelperFactory;
import by.epam.bakery.dao.api.OrderProductDao;
import by.epam.bakery.dao.exception.DaoException;
import by.epam.bakery.domain.OrderProduct;
import by.epam.bakery.service.api.OrderProductService;
import by.epam.bakery.service.exception.ServiceException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDateTime;
import java.util.List;

public class OrderProductServiceImpl implements OrderProductService {
    private DaoHelperFactory daoHelperFactory;
    private static Logger log = LogManager.getLogger(OrderProductServiceImpl.class.getName());

    public OrderProductServiceImpl(DaoHelperFactory daoHelperFactory) {
        this.daoHelperFactory = daoHelperFactory;
    }

    @Override
    public void save(int orderId, int pieId, int amount, double cost) throws ServiceException {
        log.debug("Service: saving order product started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            dao.save(orderId, pieId, amount, cost);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: saving order product finished.");
    }

    @Override
    public void deleteOrderProductById(int orderProductId) throws ServiceException {
        log.debug("Service: deleting order product started.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            dao.removeById(orderProductId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
        log.debug("Service: deleting order product finished.");
    }

    @Override
    public OrderProduct findOrderProductById (int orderProductId) throws ServiceException{
        log.debug("Service: search order product by id.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findOrderProductById(orderProductId);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderProduct> findLimitOrderProduct(int start, int amount) throws ServiceException {
        log.debug("Service: search limit order product on page.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findLimitOrderProduct(start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }

    @Override
    public List<OrderProduct> findLimitOrderProductByUserId(int userId, int start, int amount) throws ServiceException {
        log.debug("Service: search limit order product by user id.");
        try (DaoHelper helper = daoHelperFactory.create()) {
            OrderProductDao dao = helper.createOrderProductDao();
            return dao.findLimitOrderProductByUserId(userId, start, amount);
        } catch (DaoException e) {
            throw new ServiceException(e);
        }
    }
}
